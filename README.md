## Job Matcher REST API

* Run the below command to launch the API:
```
mvn spring-boot:run 
```

* Enter the following URL on browser to access the API documentation (Swagger):
```
http://localhost:8080/swagger-ui.html 
```


#### Note
* This api is using WorkerDataSeeder.java and JobDataSeeder.java to populate the worker and job details into MongoDB. This approach is only for test demonstration. In real world scenario, this should be running on separate service outside of this job matching API.
