package com.chalabookkaru.userservice.dto;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
}