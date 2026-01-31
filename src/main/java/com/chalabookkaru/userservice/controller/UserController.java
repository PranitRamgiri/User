package com.chalabookkaru.userservice.controller;

import com.chalabookkaru.userservice.dto.LoginRequest;
import com.chalabookkaru.userservice.dto.SignupRequest;
import com.chalabookkaru.userservice.dto.UserResponse;
import com.chalabookkaru.userservice.exception.UserException;
import com.chalabookkaru.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.chalabookkaru.userservice.constants.UserConstants.*;

/**
 * Simple summary for the user controller.
 * <p>
 * Functionalities:
 * - Handle user signup and login requests.
 * - Validate incoming request data.
 * - Delegate business logic to the UserService.
 * - Return appropriate HTTP responses (201 for create, 200 for login).
 * <p>
 * Annotations:
 * - @RestController — marks the class as a REST controller (stereotype).
 * - @RequestMapping(BASE_URL) — defines the controller's base URI path.
 * - @PostMapping(...) — maps HTTP POST requests to a method.
 * - @RequestBody — binds the HTTP request body to a method parameter.
 * - @Valid — triggers validation of the request object before use by the DTO constraints
 * - @Autowired — injects the UserService bean into the controller.
 * <p>
 * Code Flow:
 * - An HTTP request arrives at the controller's base path.
 * - For signup: POST to the signup path, request body is validated and bound to SignupRequest.
 * - Controller calls userService.createUser(signupRequest).
 * - Service returns UserResponse and controller sends HTTP 201 (Created).
 * - For login: POST to the login path, request body is validated and bound to LoginRequest.
 * - Controller calls userService.loginUser(loginRequest).
 * - Service returns UserResponse (or token) and controller sends HTTP 200 (OK).
 * - Any UserException thrown by the service is handled by the application's exception handler.
 */

@RestController
@RequestMapping(BASE_URL)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(SIGNUP_USER)
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody SignupRequest signupRequest) throws UserException {
        UserResponse userResponse = userService.createUser(signupRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PostMapping(LOGIN_USER)
    public ResponseEntity<UserResponse> loginUser(@Valid @RequestBody LoginRequest loginRequest) throws UserException {
        UserResponse userResponse = userService.loginUser(loginRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
