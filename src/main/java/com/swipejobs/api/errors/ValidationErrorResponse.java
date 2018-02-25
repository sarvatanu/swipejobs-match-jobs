package com.swipejobs.api.errors;


import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

public class ValidationErrorResponse {
    @ApiModelProperty(value = "Error Code", required = true, example = "InvalidRequest")
    final String code = "InvalidRequest";

    @ApiModelProperty(value = "Field Errors keyed by field name", required = true)
    Map<String, FieldError> errors = new HashMap<>();

    public void addFieldError(String path, String errorCode, String errorMessage) {

        FieldError fieldError = new FieldError( errorCode, errorMessage);
        errors.put(path, fieldError);
    }

    static class FieldError {
        String code;
        String message;

        FieldError(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
