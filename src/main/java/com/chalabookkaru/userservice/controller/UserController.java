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
