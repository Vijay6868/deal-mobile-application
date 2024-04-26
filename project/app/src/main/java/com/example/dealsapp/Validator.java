package com.example.dealsapp;

public class Validator {
    // Constants for minimum length requirements
    private static final int MIN_USERNAME_LENGTH = 5;
    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final int MIN_NAME_LENGTH = 2; // Minimum length for first name and last name
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static boolean isValidUsername(String username) {
        // Implement your validation logic for usernames here
        return isValidString(username, MIN_USERNAME_LENGTH);
    }

    public static boolean isValidPassword(String password) {
        // Implement your validation logic for passwords here
        return isValidString(password, MIN_PASSWORD_LENGTH);
    }

    public static boolean isValidFirstName(String firstName) {
        // Implement your validation logic for first name here
        return isValidString(firstName, MIN_NAME_LENGTH);
    }

    public static boolean isValidLastName(String lastName) {
        // Implement your validation logic for last name here
        return isValidString(lastName, MIN_NAME_LENGTH);
    }

    public static boolean isValidEmail(String email) {
        // Implement your validation logic for email here
        return email != null && email.matches(EMAIL_REGEX);
    }

    public static boolean isValidBusinessName(String businessName) {
        // Implement your validation logic for business name here
        // For example, if the business name cannot be empty:
        return isValidString(businessName, 3); // Minimum length of 3 for business name
    }
    public static boolean isValidJobCode(String jobCode) {
        // Implement your validation logic for business name here
        // For example, if the business name cannot be empty:
        return isValidString(jobCode, 4); // Minimum length of 4 for job code
    }

    // Generic method to validate any string attribute based on minimum length
    private static boolean isValidString(String attribute, int minLength) {
        return attribute != null && attribute.length() >= minLength;
    }

}
