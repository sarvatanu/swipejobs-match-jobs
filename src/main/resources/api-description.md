API to Get upto 3 matching job details for given worker Id.

## Supported Operations:

#### [Matches the Jobs for a given profile - /api/jobs/{workerId}](#/matchedJobs)

- Retrieves the max of 3 jobs for a given profile. It is uses the following Criterias
1. Geo location 
2. Max distance
3. Required Certificates
4. Driver license

#### Note
* This api is using WorkerDataSeeder.java and JobDataSeeder.java to populate the worker and job details into MongoDB. This approach is only for test demonstration. In real world scenario, this should be running on separate service outside of this job matching API.
