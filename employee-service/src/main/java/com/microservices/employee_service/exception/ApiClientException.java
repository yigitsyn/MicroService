package com.microservices.employee_service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ApiClientException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private String fieldValue;
    public ApiClientException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}

