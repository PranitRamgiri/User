package com.chalabookkaru.userservice.controller;

import com.chalabookkaru.userservice.dto.LoginRequest;
import com.chalabookkaru.userservice.dto.SignupRequest;
import com.chalabookkaru.userservice.dto.UserResponse;
import com.chalabookkaru.userservice.exception.UserException;
import com.chalabookkaru.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/createUser")
    public ResponseEntity<UserResponse> createUser(@RequestBody SignupRequest signupRequest) throws UserException {
        UserResponse userResponse= userService.createUser(signupRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest loginRequest)throws UserException {
        UserResponse userResponse= userService.loginUser(loginRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
