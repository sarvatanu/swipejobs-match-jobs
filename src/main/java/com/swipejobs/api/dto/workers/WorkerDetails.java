
package com.swipejobs.api.dto.workers;

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
    "rating",
    "isActive",
    "certificates",
    "skills",
    "jobSearchAddress",
    "transportation",
    "hasDriversLicense",
    "availability",
    "phone",
    "email",
    "name",
    "age",
    "guid",
    "userId"
})

@Document(
        collection = "workerdetails"
)
public class WorkerDetails {

    @Id
    @JsonProperty()
    private String id;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("certificates")
    private List<String> certificates = null;
    @JsonProperty("skills")
    private List<String> skills = null;
    @JsonProperty("jobSearchAddress")
    private JobSearchAddress jobSearchAddress;
    @JsonProperty("transportation")
    private String transportation;
    @JsonProperty("hasDriversLicense")
    private Boolean hasDriversLicense;
    @JsonProperty("availability")
    private List<Availability> availability = null;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private Name name;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("guid")
    private String guid;
    @JsonProperty("userId")
    private Integer userId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rating")
    public Integer getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("certificates")
    public List<String> getCertificates() {
        return certificates;
    }

    @JsonProperty("certificates")
    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

    @JsonProperty("skills")
    public List<String> getSkills() {
        return skills;
    }

    @JsonProperty("skills")
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @JsonProperty("jobSearchAddress")
    public JobSearchAddress getJobSearchAddress() {
        return jobSearchAddress;
    }

    @JsonProperty("jobSearchAddress")
    public void setJobSearchAddress(JobSearchAddress jobSearchAddress) {
        this.jobSearchAddress = jobSearchAddress;
    }

    @JsonProperty("transportation")
    public String getTransportation() {
        return transportation;
    }

    @JsonProperty("transportation")
    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    @JsonProperty("hasDriversLicense")
    public Boolean getHasDriversLicense() {
        return hasDriversLicense;
    }

    @JsonProperty("hasDriversLicense")
    public void setHasDriversLicense(Boolean hasDriversLicense) {
        this.hasDriversLicense = hasDriversLicense;
    }

    @JsonProperty("availability")
    public List<Availability> getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    @JsonProperty("guid")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return new ToStringBuilder(this).append("rating", rating).append("isActive", isActive).append("certificates", certificates).append("skills", skills).append("jobSearchAddress", jobSearchAddress).append("transportation", transportation).append("hasDriversLicense", hasDriversLicense).append("availability", availability).append("phone", phone).append("email", email).append("name", name).append("age", age).append("guid", guid).append("userId", userId).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(skills).append(phone).append(hasDriversLicense).append(jobSearchAddress).append(transportation).append(guid).append(isActive).append(email).append(additionalProperties).append(userId).append(age).append(name).append(rating).append(availability).append(certificates).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WorkerDetails) == false) {
            return false;
        }
        WorkerDetails rhs = ((WorkerDetails) other);
        return new EqualsBuilder().append(skills, rhs.skills).append(phone, rhs.phone).append(hasDriversLicense, rhs.hasDriversLicense).append(jobSearchAddress, rhs.jobSearchAddress).append(transportation, rhs.transportation).append(guid, rhs.guid).append(isActive, rhs.isActive).append(email, rhs.email).append(additionalProperties, rhs.additionalProperties).append(userId, rhs.userId).append(age, rhs.age).append(name, rhs.name).append(rating, rhs.rating).append(availability, rhs.availability).append(certificates, rhs.certificates).isEquals();
    }

}
