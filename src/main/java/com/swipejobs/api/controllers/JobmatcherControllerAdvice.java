package com.swipejobs.api.controllers;

import com.swipejobs.api.errors.NotFoundErrorResponse;
import com.swipejobs.api.errors.ValidationErrorResponse;
import com.swipejobs.api.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class JobmatcherControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse handleValidationError(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        ValidationErrorResponse response = new ValidationErrorResponse();

        for (FieldError fieldError : fieldErrors) {
            response.addFieldError(fieldError.getField(), fieldError.getCode(), fieldError.getDefaultMessage());
        }

        return response;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    NotFoundErrorResponse handleNotFoundException(NotFoundException e) {
        return new NotFoundErrorResponse(e.getId(), e.getMessage());
    }
}
