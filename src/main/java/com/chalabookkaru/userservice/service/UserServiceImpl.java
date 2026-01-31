package com.chalabookkaru.userservice.service;

import com.chalabookkaru.userservice.dto.LoginRequest;
import com.chalabookkaru.userservice.dto.SignupRequest;
import com.chalabookkaru.userservice.dto.UserResponse;
import com.chalabookkaru.userservice.entity.User;
import com.chalabookkaru.userservice.exception.UserException;
import com.chalabookkaru.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse createUser(SignupRequest signupRequest) throws UserException {
        Optional<User> userOptional = userRepository.findByEmail(signupRequest.getEmail());
        if (userOptional.isPresent()) {
            throw new UserException("User already ahe!! Navin User Banav!!");
        }
        User userToSave = new User();
        userToSave.setEmail(signupRequest.getEmail());
        userToSave.setPassword(signupRequest.getPassword());
        userToSave.setCreatedAt(String.valueOf(LocalDateTime.now()));
        User savedUser= userRepository.save(userToSave);

        UserResponse response = new UserResponse();
        response.setUserId(savedUser.getId());
        response.setMessage("User Banla!!");
        return response;
    }

    @Override
    public UserResponse loginUser(LoginRequest loginRequest) throws UserException {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
        if (userOptional.isEmpty()) {
            throw new UserException("He User Nahiye amchyakde, jaa Account Banav!!");
        }
        UserResponse loginResponse= new UserResponse();
        loginResponse.setUserId(userOptional.get().getId());
        loginResponse.setMessage("Login Zalaaaa reeeee!!!");
        return loginResponse;
    }
}
