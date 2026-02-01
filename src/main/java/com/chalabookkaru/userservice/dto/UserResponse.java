package com.chalabookkaru.userservice.dto;

/**
 * Data transfer object used to return results of user-related operations.
 * <p>
 * Functionalities:
 * - Holds the user's username (typically the unique identifier).
 * - Carries a human-readable message describing the operation outcome
 * (for example: "User created successfully", "User not found").
 * <p>
 * Annotations:
 * - @Getter / @Setter (Lombok) — generate standard getters and setters.
 * - @AllArgsConstructor / @NoArgsConstructor (Lombok) — generate all-args and no-args constructors.
 * <p>
 * Code flow:
 * 1. A service or controller constructs an instance (using the all-args constructor or setters).
 * 2. The object is returned from a controller method (commonly wrapped in ResponseEntity).
 * 3. Spring's HTTP message converters serialize the object to JSON for the HTTP response.
 */


public class UserResponse {
    private String username;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
