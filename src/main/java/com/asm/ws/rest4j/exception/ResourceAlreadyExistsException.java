package com.asm.ws.rest4j.exception;

/**
 * @author ashut
 * @since 31-08-2024
 */

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}

