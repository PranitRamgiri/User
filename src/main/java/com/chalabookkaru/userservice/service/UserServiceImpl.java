package com.chalabookkaru.userservice.service;

import com.chalabookkaru.userservice.dto.LoginRequest;
import com.chalabookkaru.userservice.dto.SignupRequest;
import com.chalabookkaru.userservice.dto.UserResponse;
import com.chalabookkaru.userservice.entity.User;
import com.chalabookkaru.userservice.exception.UserException;
import com.chalabookkaru.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.chalabookkaru.userservice.constants.UserConstants.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse createUser(SignupRequest signupRequest) throws UserException {

        String email = signupRequest.getEmail();
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new UserException(USER_ALREADY_EXIST, HttpStatus.CONFLICT);
        }

        User userToSave = new User();

        userToSave.setEmail(email);
        userToSave.setUsername(signupRequest.getUsername());
        userToSave.setPassword(signupRequest.getPassword());
        userToSave.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(userToSave);

        UserResponse response = new UserResponse();
        response.setUsername(savedUser.getUsername());
        response.setMessage(ACCOUNT_CREATED_SUCCESS);
        return response;
    }

    @Override
    public UserResponse loginUser(LoginRequest loginRequest) throws UserException {

        String loginId = loginRequest.getEmailOrUsername();
        Optional<User> userOptional = loginId.contains(EMAIL_CHECK) ? userRepository.findByEmail(loginId) : userRepository.findByUsername(loginId);

        if (userOptional.isEmpty()) {
            throw new UserException(LOGIN_USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        UserResponse loginResponse = new UserResponse();
        loginResponse.setUsername(userOptional.get().getUsername());

        if (loginRequest.getPassword().equals(userOptional.get().getPassword())) {
            loginResponse.setMessage(LOGIN_SUCCESS);
        } else {
            throw new UserException(INCORRECT_PASSWORD, HttpStatus.BAD_REQUEST);
        }
        return loginResponse;
    }
}
