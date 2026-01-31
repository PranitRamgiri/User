package com.chalabookkaru.userservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "{user.emailOrUsername.notBlank}")
    private String emailOrUsername;

    @NotBlank(message = "{user.password.notBlank}")
    private String password;
}
