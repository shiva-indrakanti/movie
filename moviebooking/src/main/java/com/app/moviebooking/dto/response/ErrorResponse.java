package com.app.moviebooking.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private String method;
    private List<Long> missingIds;
    private String requestId;

    public ErrorResponse(LocalDateTime timestamp, int status, String error, String message,
                         String path, String method, List<Long> missingIds,String requestId) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.method = method;
        this.missingIds = missingIds;
        this.requestId = requestId;
    }
}
