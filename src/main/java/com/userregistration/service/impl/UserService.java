package main.java.com.userregistration.service.impl;

import main.java.com.userregistration.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService implements main.java.com.userregistration.service.UserService {
    List<User> users = new ArrayList<User>();

    @Override
    public boolean registerUser(User user) {
        try {
            users.add(user);
            return true;
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserByUsername(String username) {
        for (User user : users) {
            if(user.getUserName().equals(username)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean deleteAllUsers() {
        try {
            users.clear();
            return true;
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteUserByUsername(String username) {
        for (User user : users) {
            if(user.getUserName().equals(username)){
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(String userName, String firstName, String lastName, Date dateOfBirth ) {
        for (User user : users) {
            if(user.getUserName().equals(userName)){
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setDateOfBirth(dateOfBirth);
                return true;
            }
        }
        return false;
    }

    // Validate User
    public boolean checkIfUserExists(String username) {
        for (User user : users) {
            if(user.getUserName().equals(username)){
                return true;
            }
        }
        return false;
    }
}
