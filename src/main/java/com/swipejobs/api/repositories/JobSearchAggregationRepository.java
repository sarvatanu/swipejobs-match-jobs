package com.swipejobs.api.repositories;


import com.swipejobs.api.dto.jobs.JobDetails;
import com.swipejobs.api.dto.workers.WorkerDetails;

import java.util.List;

public interface JobSearchAggregationRepository {

    List<JobDetails> aggregate(WorkerDetails workerDetails);
}
