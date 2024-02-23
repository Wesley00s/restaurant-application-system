package com.wesley.restaurant.application.system.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ExceptionDetails {
    private String title;
    private LocalDateTime timestamp;
    private Integer status;
    private String exception;
    private Map<String, String> details = new HashMap<>();

    public ExceptionDetails(String title, LocalDateTime timestamp, Integer status, String exception, Map<String, String> details) {
        this.title = title;
        this.timestamp = timestamp;
        this.status = status;
        this.exception = exception;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getException() {
        return exception;
    }

    public Map<String, String> getDetails() {
        return details;
    }
}
