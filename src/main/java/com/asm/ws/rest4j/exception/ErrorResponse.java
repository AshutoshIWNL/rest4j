package com.asm.ws.rest4j.exception;

import java.time.LocalDateTime;

/**
 * @author ashut
 * @since 31-08-2024
 */

public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;

    public ErrorResponse(LocalDateTime timestamp, int status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}