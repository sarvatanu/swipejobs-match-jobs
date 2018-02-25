package com.swipejobs.api.repositories;


import com.swipejobs.api.dto.jobs.JobDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDetailsRepository extends MongoRepository<JobDetails, String>  {

}


