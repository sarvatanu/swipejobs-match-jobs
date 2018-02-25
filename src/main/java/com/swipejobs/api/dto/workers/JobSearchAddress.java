
package com.swipejobs.api.dto.workers;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "unit",
    "maxJobDistance",
    "longitude",
    "latitude"
})
public class JobSearchAddress {

    @JsonProperty("unit")
    private String unit;
    @JsonProperty("maxJobDistance")
    private Integer maxJobDistance;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("latitude")
    private String latitude;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @JsonProperty("maxJobDistance")
    public Integer getMaxJobDistance() {
        return maxJobDistance;
    }

    @JsonProperty("maxJobDistance")
    public void setMaxJobDistance(Integer maxJobDistance) {
        this.maxJobDistance = maxJobDistance;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
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
        return new ToStringBuilder(this).append("unit", unit).append("maxJobDistance", maxJobDistance).append("longitude", longitude).append("latitude", latitude).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(unit).append(additionalProperties).append(maxJobDistance).append(longitude).append(latitude).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobSearchAddress) == false) {
            return false;
        }
        JobSearchAddress rhs = ((JobSearchAddress) other);
        return new EqualsBuilder().append(unit, rhs.unit).append(additionalProperties, rhs.additionalProperties).append(maxJobDistance, rhs.maxJobDistance).append(longitude, rhs.longitude).append(latitude, rhs.latitude).isEquals();
    }

}
