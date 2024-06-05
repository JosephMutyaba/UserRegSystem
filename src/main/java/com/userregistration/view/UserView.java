package main.java.com.userregistration.view;

import main.java.com.userregistration.model.User;
import main.java.com.userregistration.service.impl.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserView {
    UserService userService = new UserService();
    Scanner scanner = new Scanner(System.in);

    public void registerUser() {
        try {
            System.out.println("Enter your username: ");
            String username = scanner.nextLine();
            System.out.println("Enter your First name: ");
            String firstName = scanner.nextLine();
            System.out.println("Enter your Last name: ");
            String lastName = scanner.nextLine();
            System.out.println("Enter your Date of Birth((DD/MM/YYYY)): ");
            String dateOfBirth = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dob = sdf.parse(dateOfBirth);

            User user = new User(firstName, lastName,username, dob);
            boolean isRegistered=userService.registerUser(user);
            if (isRegistered) {
                System.out.println("You have successfully registered!\n");
            }else {
                System.out.println("Something went wrong, please try again!\n");
            }

        } catch (Exception e) {
            System.out.println("Enter the correct format of your credentials\n");
        }
    }

    public void getAllUsers() {
        List<User> users = userService.getAllUsers();

        for (User user : users) {
            System.out.println("Username: "+user.getUserName());
            System.out.println("Name: "+user.getFirstName()+" "+user.getLastName());
            System.out.println("Date of Birth: "+user.getDateOfBirth()+"\n");
            System.out.println("*************************************************************");
        }
    }

    public void getUserByUsername() {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        try {
            User user = userService.getUserByUsername(username);
            System.out.println("Username: "+username);
            System.out.println("First name: "+user.getFirstName());
            System.out.println("Last name: "+user.getLastName());
            System.out.println("Date of Birth: "+user.getDateOfBirth());
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage()+"\n");
        }
    }

    public void deleteAllUsers() {
        boolean allUsersDeleted=userService.deleteAllUsers();
        if (allUsersDeleted) {
            System.out.println("All users have been successfully deleted!\n");
        }else {
            System.out.println("Deletion Unsuccessful, please try again!\n");
        }
    }

    public void deleteUserByUsername() {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        boolean usersDeleted=userService.deleteUserByUsername(username);
        if (usersDeleted) {
            System.out.println("User has been successfully deleted!\n");
        }else {
            System.out.println("Deletion Unsuccessful, please try again!\n");
        }
    }

    public void updateUser( ) {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        try {
            if (userService.checkIfUserExists(username)) {
                System.out.println("Enter your First name: ");
                String firstName=scanner.nextLine();
                System.out.println("Enter your Last name: ");
                String lastName=scanner.nextLine();
                System.out.println("Enter your Date of Birth (DD/MM/YYYY): ");
                String dateOfBirth2=scanner.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dob = sdf.parse(dateOfBirth2);

                boolean userUpdated=userService.updateUser(username, firstName,lastName,dob);
                if (userUpdated) {
                    System.out.println("User updated successfully\n");
                }else {
                    System.out.println("Sorry, User could not be updated\n");
                }
            }else {
                System.out.println("There is no such username! \n");
            }
        } catch (Exception e) {
            System.out.println("""
                    Could not update user.
                    Make sure you enter
                    the correct format of the information
                    """);
        }

    }



}
