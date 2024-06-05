package main.java.com.userregistration.view;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserView userView = new UserView();
        Scanner sc = new Scanner(System.in);

        while (true) {
            // print the menu for user to choose
            System.out.println("USER REG SYSTEM" +
                    "\n1.Register user" +
                    "\n2.List all users" +
                    "\n3.Get a user by username" +
                    "\n4.Delete all users" +
                    "\n5.Delete a user by username" +
                    "\n6.Update user details" +
                    "\n7.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    userView.registerUser();
                    break;
                case 2:
                    userView.getAllUsers();
                    break;
                case 3:
                    userView.getUserByUsername();
                    break;
                case 4:
                    userView.deleteAllUsers();
                    break;
                case 5:
                    userView.deleteUserByUsername();
                    break;
                case 6:
                    userView.updateUser();
                    break;
                case 7:
                    exitSystem();
                    break;
                default:
                    System.out.println("Invalid Choice, please try again");
                    break;
            }
        }
    }

    public static void exitSystem() {
        System.exit(0);
    }
}