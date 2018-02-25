package com.swipejobs.api.controllers;

import com.swipejobs.api.dto.jobs.JobDetails;
import com.swipejobs.api.services.JobMatchingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/api")
@ApiResponses({
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found")
})
public class JobmatcherController {

    private final JobMatchingService jobMatchingService;

    @Autowired
    public JobmatcherController(JobMatchingService jobMatchingService) {
        this.jobMatchingService = jobMatchingService;
    }

    @ApiOperation(value = "retrieves Matched jobs for given worker id", tags = "matchedJobs")
    @RequestMapping(value = "/jobs/{workerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<JobDetails> matchedJobs(@PathVariable @ApiParam(value = "Worker Id") Integer workerId) {
        List<JobDetails> matchedJobs = jobMatchingService.findAppropriateJobs(workerId);
        return matchedJobs;
    }
}
