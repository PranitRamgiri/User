package com.chalabookkaru.userservice.dto;

import java.time.LocalDateTime;

/**
 * Functionalities:
 * - Represents a simple error payload returned to clients.
 * - Contains when the error occurred (timestamp), the HTTP status code (status),
 * and a human-readable message (message).
 * <p>
 * Annotations:
 * - Uses Lombok annotations to reduce boilerplate:
 * - @Getter and @Setter: generate getters and setters for all fields.
 * - @AllArgsConstructor: generates a constructor with all fields.
 * <p>
 * Code Flow:
 * - An instance is created when an error needs to be sent (for example by an exception handler).
 * - The timestamp, status, and message are set and the object is serialized in the HTTP response body.
 */


public record ErrorResponse(LocalDateTime timestamp, int status, String message) {

}
