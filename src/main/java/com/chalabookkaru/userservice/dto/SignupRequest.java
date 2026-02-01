package com.chalabookkaru.userservice.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * SignupRequest
 * <p>
 * Functionalities:
 * - Holds signup input data: email, username, and password.
 * - Validates input so only properly formed and non-empty values are accepted.
 * - Lombok generates getters, setters, and a no-argument constructor.
 * <p>
 * Annotations:
 * - @Email: ensures the email looks like a valid email address (uses message key {user.email.invalid}).
 * - @NotBlank: ensures a field is not null, empty, or only whitespace (uses keys like {user.email.notBlank}, {user.username.notBlank}, {user.password.notBlank}).
 * - @Size: enforces minimum and maximum length for username and password (uses keys like {user.username.invalid}; password currently reuses {user.email.invalid}, consider changing).
 * - @Getter, @Setter, @NoArgsConstructor (Lombok): auto-generate common boilerplate methods.
 * <p>
 * Code Flow:
 * - A controller binds incoming signup JSON to this DTO.
 * - Jakarta Bean Validation (triggered by Spring) checks the annotated constraints.
 * - If validation succeeds, the controller calls service logic to create the user and persist it.
 * - If validation fails, the framework returns validation errors to the client using the configured message keys.
 * <p>
 * Notes:
 * - Message keys map to localization entries (e.g., messages.properties).
 * - Consider updating the password @Size message key to a password-specific key for clearer messages.
 */


public class SignupRequest {

    @Email(message = "{user.email.invalid}")
    @NotBlank(message = "{user.email.notBlank}")
    private String email;

    @NotBlank(message = "{user.username.notBlank}")
    @Size(min = 3, max = 15, message = "{user.username.invalid}")
    private String username;

    @NotBlank(message = "{user.password.notBlank}")
    @Size(min = 5, max = 15, message = "{user.email.invalid}")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}