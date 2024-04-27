package com.example.dealsapp;

public class UserFactory {
    public static User createUser(String userType, String firstName, String lastName, String username, String password, String email, String businessName, String jobcode) {
        switch (userType) {
            case "admin":
                return new Admin(userType, firstName, lastName, username, password, email,jobcode);
            case "supplier":
                return new Supplier(userType, firstName, lastName, username, password, email, businessName);
            case "standard":
                return new StandardUser(userType,firstName, lastName, username, password, email);
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }
}
