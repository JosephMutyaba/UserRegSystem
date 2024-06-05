package main.java.com.userregistration.service;

import main.java.com.userregistration.model.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    public boolean registerUser(User user);
    public List<User> getAllUsers();
    public User getUserByUsername(String username);
    public boolean deleteAllUsers();
    public boolean deleteUserByUsername(String username);
    public boolean updateUser(String userName, String firstName, String lastName, Date dateOfBirth);

}
