package com.swipejobs.api.utils;


import com.swipejobs.api.dto.workers.WorkerDetails;
import com.swipejobs.api.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class WorkerDataSeeder extends JsonUtils implements CommandLineRunner {

    @Value("${seeder.endpoint.workers}")
    private String RESORUCE_ENDPOINT;

    private final RestTemplate restTemplate;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public WorkerDataSeeder(RestTemplate restTemplate, MongoTemplate mongoTemplate) {
        this.restTemplate = restTemplate;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        ResponseEntity<List<WorkerDetails>> endPointResponse = restTemplate.exchange(RESORUCE_ENDPOINT,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<WorkerDetails>>() {
                });

        endPointResponse.getBody().forEach(WorkerDetail -> mongoTemplate.save(WorkerDetail));
    }

}
