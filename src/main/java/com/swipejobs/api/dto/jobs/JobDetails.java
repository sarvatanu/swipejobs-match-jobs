
package com.swipejobs.api.dto.jobs;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "about",
    "billRate",
    "company",
    "driverLicenseRequired",
    "guid",
    "jobId",
    "jobTitle",
    "location",
    "requiredCertificates",
    "startDate",
    "workersRequired"
})
@Document(
        collection = "jobdetails"
)
public class JobDetails {

    @Id
    @JsonProperty()
    private String id;

    @JsonProperty("about")
    private String about;
    @JsonProperty("billRate")
    private String billRate;
    @JsonProperty("company")
    private String company;
    @JsonProperty("driverLicenseRequired")
    private Boolean driverLicenseRequired;
    @JsonProperty("guid")
    private String guid;
    @JsonProperty("jobId")
    private Integer jobId;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("location")
    private  Double[] location;
    @JsonProperty("requiredCertificates")
    private List<String> requiredCertificates = null;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("workersRequired")
    private Integer workersRequired;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("about")
    public String getAbout() {
        return about;
    }

    @JsonProperty("about")
    public void setAbout(String about) {
        this.about = about;
    }

    @JsonProperty("billRate")
    public String getBillRate() {
        return billRate;
    }

    @JsonProperty("billRate")
    public void setBillRate(String billRate) {
        this.billRate = billRate;
    }

    @JsonProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }

    @JsonProperty("driverLicenseRequired")
    public Boolean getDriverLicenseRequired() {
        return driverLicenseRequired;
    }

    @JsonProperty("driverLicenseRequired")
    public void setDriverLicenseRequired(Boolean driverLicenseRequired) {
        this.driverLicenseRequired = driverLicenseRequired;
    }

    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    @JsonProperty("guid")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty("jobId")
    public Integer getJobId() {
        return jobId;
    }

    @JsonProperty("jobId")
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    @JsonProperty("jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("jobTitle")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @JsonProperty("location")
    public Double[] getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        Double[] loc  = {Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())};
        this.location = loc;
    }

    @JsonProperty("requiredCertificates")
    public List<String> getRequiredCertificates() {
        return requiredCertificates;
    }

    @JsonProperty("requiredCertificates")
    public void setRequiredCertificates(List<String> requiredCertificates) {
        this.requiredCertificates = requiredCertificates;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("workersRequired")
    public Integer getWorkersRequired() {
        return workersRequired;
    }

    @JsonProperty("workersRequired")
    public void setWorkersRequired(Integer workersRequired) {
        this.workersRequired = workersRequired;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("about", about).append("billRate", billRate).append("company", company).append("driverLicenseRequired", driverLicenseRequired).append("guid", guid).append("jobId", jobId).append("jobTitle", jobTitle).append("location", location).append("requiredCertificates", requiredCertificates).append("startDate", startDate).append("workersRequired", workersRequired).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(startDate).append(requiredCertificates).append(jobId).append(location).append(about).append(guid).append(driverLicenseRequired).append(billRate).append(additionalProperties).append(company).append(workersRequired).append(jobTitle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobDetails) == false) {
            return false;
        }
        JobDetails rhs = ((JobDetails) other);
        return new EqualsBuilder().append(startDate, rhs.startDate).append(requiredCertificates, rhs.requiredCertificates).append(jobId, rhs.jobId).append(location, rhs.location).append(about, rhs.about).append(guid, rhs.guid).append(driverLicenseRequired, rhs.driverLicenseRequired).append(billRate, rhs.billRate).append(additionalProperties, rhs.additionalProperties).append(company, rhs.company).append(workersRequired, rhs.workersRequired).append(jobTitle, rhs.jobTitle).isEquals();
    }

}
