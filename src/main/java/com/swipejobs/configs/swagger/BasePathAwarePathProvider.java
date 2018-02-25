package com.swipejobs.configs.swagger;

import springfox.documentation.spring.web.paths.AbstractPathProvider;

public class BasePathAwarePathProvider extends AbstractPathProvider {

    private String basePath;

    BasePathAwarePathProvider(String basePath) {
        this.basePath = basePath;
    }


    @Override
    protected String applicationPath() {
        return basePath;
    }

    @Override
    protected String getDocumentationPath() {
        return "/";
    }
}
