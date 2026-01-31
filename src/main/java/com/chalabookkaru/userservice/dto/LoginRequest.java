package com.chalabookkaru.userservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Functionalities:
 * - Holds user login data: either an email or a username, and a password.
 * - Acts as a data carrier between incoming requests (e.g., REST controller)
 * and the authentication logic.
 * <p>
 * Annotations:
 * - @Getter, @Setter: Lombok generates standard getter and setter methods.
 * - @NoArgsConstructor: Lombok generates a no-argument constructor.
 * - @NotBlank on fields: validation rule that ensures values are not null or empty.
 * <p>
 * Code Flow:
 * - A controller receives a login request and maps the request body to this class.
 * - Validation (e.g., via Spring) checks @NotBlank constraints; if invalid, an error is returned.
 * - If valid, the controller/service reads emailOrUsername and password to authenticate the user.
 */

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "{user.emailOrUsername.notBlank}")
    private String emailOrUsername;

    @NotBlank(message = "{user.password.notBlank}")
    private String password;
}
