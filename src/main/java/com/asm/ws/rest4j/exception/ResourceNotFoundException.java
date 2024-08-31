package com.asm.ws.rest4j.exception;

/**
 * @author ashut
 * @since 31-08-2024
 */

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
