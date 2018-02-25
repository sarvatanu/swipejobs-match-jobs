package com.swipejobs.api.repositories;


import com.swipejobs.api.dto.workers.WorkerDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerDetailsRepository extends MongoRepository<WorkerDetails, String> {

    WorkerDetails findByUserId(Integer userId);
}
