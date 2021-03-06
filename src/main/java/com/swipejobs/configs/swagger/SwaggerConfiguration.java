package com.swipejobs.configs.swagger;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Value("${swagger.api.path:/}")
    String swaggerBasePath;

    @Bean
    public Docket api()  {
        Docket swagger = new Docket(DocumentationType.SWAGGER_2);
        String apiDescription = "";

        try {
             apiDescription = IOUtils.toString(new ClassPathResource("api-description.md").getInputStream());

        } catch (IOException  ioe) {
            throw new BeanCreationException(ioe.getMessage());
        }

       ApiInfo apiInfo = new ApiInfo(
                "Job Matcher API",
               apiDescription,
                "v1",
                "urn:tos",
                "",
                "SwipeJobs \u2122",
                "http://www.swipejobs.com/"
        );
        swagger.apiInfo(apiInfo);

        swagger.tags(
                new Tag("matchedJobs", "Display matched jobs")
        );

        swagger.pathProvider(new BasePathAwarePathProvider(swaggerBasePath));

        swagger.select().apis(RequestHandlerSelectors.basePackage("com.swipejobs.api")).paths(PathSelectors.any()).build();

        return swagger;
    }
}
