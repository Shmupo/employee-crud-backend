package com.example.employee_demo_backend.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String varName;
    private Long varVal;

    public ResourceNotFoundException(String resourceName, String varName, Long varVal) {
        super(String.format("%s not found with value %s: %s", resourceName, varName, varVal));
        this.resourceName = resourceName;
        this.varName = varName;
        this.varVal = varVal;
    }
}
