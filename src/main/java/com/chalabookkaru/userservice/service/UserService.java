package com.chalabookkaru.userservice.service;

import com.chalabookkaru.userservice.dto.LoginRequest;
import com.chalabookkaru.userservice.dto.SignupRequest;
import com.chalabookkaru.userservice.dto.UserResponse;
import com.chalabookkaru.userservice.exception.UserException;

public interface UserService {
    UserResponse createUser(SignupRequest signupRequest) throws UserException;
    UserResponse loginUser(LoginRequest loginRequest) throws UserException;
}
