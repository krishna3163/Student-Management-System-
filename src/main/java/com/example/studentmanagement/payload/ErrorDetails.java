package com.example.studentmanagement.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * REST API response me standard error format return karne ke liye DTO class.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private LocalDateTime timestamp; // Error temporal timestamp
    private int status; // HTTP Status Code (e.g. 404, 400, 409)
    private String error; // Short error title (e.g. Not Found, Bad Request)
    private String message; // User friendly error message
    private String path; // Request URI path
    private Map<String, String> validationErrors; // Field validation error map

    public ErrorDetails(LocalDateTime timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
