package com.example.dealsapp;

import java.util.ArrayList;

public class UserManager {
    private static UserManager instance;
    private ArrayList<User> users;

    private UserManager() {
        this.users = new ArrayList<>();
    }

    public static synchronized UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
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
