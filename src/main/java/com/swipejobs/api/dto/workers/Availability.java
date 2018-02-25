
package com.swipejobs.api.dto.workers;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "dayIndex"
})
public class Availability {

    @JsonProperty("title")
    private String title;
    @JsonProperty("dayIndex")
    private Integer dayIndex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("dayIndex")
    public Integer getDayIndex() {
        return dayIndex;
    }

    @JsonProperty("dayIndex")
    public void setDayIndex(Integer dayIndex) {
        this.dayIndex = dayIndex;
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
        return new ToStringBuilder(this).append("title", title).append("dayIndex", dayIndex).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dayIndex).append(title).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Availability) == false) {
            return false;
        }
        Availability rhs = ((Availability) other);
        return new EqualsBuilder().append(dayIndex, rhs.dayIndex).append(title, rhs.title).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
