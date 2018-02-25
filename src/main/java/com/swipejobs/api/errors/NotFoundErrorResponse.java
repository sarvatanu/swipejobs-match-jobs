package com.swipejobs.api.errors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Not Found", description = "Resource not found")
public class NotFoundErrorResponse {

    @ApiModelProperty(value = "ID", required = true)
    public Integer id;

    @ApiModelProperty(value = "Message", example = "Worker id xxx is not found")
    public String message;

    public NotFoundErrorResponse(Integer id, String message) {
        this.id = id;
        this.message = message;
    }
}
