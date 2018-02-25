package com.swipejobs.api.services;

import com.swipejobs.api.dto.jobs.JobDetails;
import com.swipejobs.api.dto.workers.WorkerDetails;
import com.swipejobs.api.exceptions.NotFoundException;
import com.swipejobs.api.repositories.JobSearchAggregationRepository;
import com.swipejobs.api.repositories.WorkerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobMatchingService {

    private final WorkerDetailsRepository workerDetailsRepository;
    private final JobSearchAggregationRepository jobSearchAggregationRepository;

    @Autowired
    public JobMatchingService(WorkerDetailsRepository workerDetailsRepository, JobSearchAggregationRepository jobSearchAggregationRepository) {
        this.workerDetailsRepository = workerDetailsRepository;
        this.jobSearchAggregationRepository = jobSearchAggregationRepository;
    }

    private WorkerDetails findWorker(Integer workerId) {
        return workerDetailsRepository.findByUserId(workerId);
    }

    public List<JobDetails> findAppropriateJobs(Integer workerId) {
        WorkerDetails findWorker = findWorker(workerId);
        if (findWorker == null) {
            throw new NotFoundException(workerId, "Worker Id " + workerId + " not found");
        }
        return aggregateJobs(findWorker);
    }

    private List<JobDetails> aggregateJobs(WorkerDetails workerDetails) {
        return jobSearchAggregationRepository.aggregate(workerDetails);
    }
}
