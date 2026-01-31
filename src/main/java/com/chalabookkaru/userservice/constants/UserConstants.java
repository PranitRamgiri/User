package com.chalabookkaru.userservice.constants;

/**
 * Holds application-wide constants for the users service.
 * This class provides string constants for table name, endpoint paths and
 * user-facing messages related to user signup and login operations.
 */

public class UserConstants {
    public static final String TABLE = "users";
    public static final String BASE_URL = "/users";
    public static final String SIGNUP_USER = "/signup";
    public static final String LOGIN_USER = "/login";
    public static final String EMAIL_CHECK = "@";
    public static final String USER_ALREADY_EXIST = "User already exists, please create a new one!";
    public static final String ACCOUNT_CREATED_SUCCESS = "Account created successfully!";
    public static final String LOGIN_USER_NOT_FOUND = "Login user not found, please check the username or email!";
    public static final String LOGIN_SUCCESS = "User login successful!";
    public static final String INCORRECT_PASSWORD = "Incorrect password, please enter correct password!";

}
