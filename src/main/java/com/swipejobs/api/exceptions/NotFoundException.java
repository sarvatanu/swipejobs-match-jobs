package com.swipejobs.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public Integer getId() {
        return id;
    }

    public final Integer id;

    public NotFoundException(Integer id, String message) {
        super(message);
        this.id = id;
    }
}
