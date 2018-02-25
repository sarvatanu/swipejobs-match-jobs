package com.swipejobs.api.utils;

import com.swipejobs.api.dto.jobs.JobDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class JobDataSeeder implements CommandLineRunner {

    @Value("${seeder.endpoint.jobs}")
    private String RESORUCE_ENDPOINT;

    private final RestTemplate restTemplate;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public JobDataSeeder(RestTemplate restTemplate, MongoTemplate mongoTemplate) {
        this.restTemplate = restTemplate;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... strings) throws Exception {
        ResponseEntity<List<JobDetails>> endPointResponse = restTemplate.exchange(RESORUCE_ENDPOINT,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<JobDetails>>() {
                });

        endPointResponse.getBody().forEach(jobDetail -> mongoTemplate.save(jobDetail));
        mongoTemplate.indexOps(JobDetails.class).ensureIndex(new GeospatialIndex("location"));
    }
}
