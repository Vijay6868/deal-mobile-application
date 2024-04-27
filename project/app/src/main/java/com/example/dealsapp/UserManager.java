package com.example.dealsapp;

import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean isUsernameAvailable(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Username already exists
            }
        }
        return true; // Username is available
    }

    public boolean isValidLogin(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Username and password match
            }
        }
        return false; // Username or password is incorrect
    }
}
