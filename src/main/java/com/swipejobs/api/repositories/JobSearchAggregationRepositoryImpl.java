package com.swipejobs.api.repositories;

import com.swipejobs.api.dto.jobs.JobDetails;
import com.swipejobs.api.dto.workers.WorkerDetails;
import com.swipejobs.api.repositories.JobSearchAggregationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class JobSearchAggregationRepositoryImpl implements JobSearchAggregationRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public JobSearchAggregationRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<JobDetails> aggregate(WorkerDetails workerDetails) {

        final NearQuery geoNear = NearQuery.near(new Point(Double.valueOf(workerDetails.getJobSearchAddress().getLatitude()),
                Double.valueOf(workerDetails.getJobSearchAddress().getLongitude())), Metrics.KILOMETERS).maxDistance(workerDetails.getJobSearchAddress().getMaxJobDistance());

        GeoNearOperation geoNearOperation = geoNear(geoNear, "distance" );
        MatchOperation matchOperation = getMatchOperation(workerDetails);
        LimitOperation limitOperation = limit(3);

        final Aggregation aggregation = newAggregation( geoNearOperation, matchOperation, limitOperation);

        final AggregationResults<JobDetails> results = mongoTemplate.aggregate(aggregation, "jobdetails", JobDetails.class);

        final List<JobDetails> matchedJobs = new ArrayList<JobDetails>(results.getMappedResults());
        return matchedJobs;
    }

    private MatchOperation getMatchOperation(WorkerDetails workerDetails) {
        Criteria criterias = where("requiredCertificates").in(workerDetails.getCertificates());

        /**
         * when worker has no driving license, then only return jobs which requires no license.
         * otherwise, ignore driving license crieria.
         */
        if(!workerDetails.getHasDriversLicense()) {
            criterias.and("driverLicenseRequired").is(false);
        }

        return match(criterias);
    }
}
