package main.java.com.userregistration.model;

import java.util.Date;

public class User {
    // attributes
    private String firstName;
    private String lastName;
    private String userName;
    private Date dateOfBirth;

    // default constructor
    public User() {
    }

    // constructor
    public User(String firstName, String lastName, String userName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Override for the toString method

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public int hashCode() {
        int result =17; // starting with 17
        if (this.userName != null) {
            result = 31 * result + userName.hashCode();
        }
        if (this.firstName != null) {
            result = 31 * result + firstName.hashCode();
        }
        if (this.lastName != null) {
            result = 31 * result + lastName.hashCode();
        }if (this.dateOfBirth != null) {
            result = 31 * result + dateOfBirth.hashCode();
        }
        return result ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User usr = (User) obj;

        return this.dateOfBirth != null ? this.dateOfBirth.equals(usr.dateOfBirth) : usr.dateOfBirth == null &&
                this.firstName != null ? this.firstName.equals(usr.firstName): usr.firstName ==null &&
                this.lastName != null ? this.lastName.equals(usr.lastName): usr.lastName ==null &&
                this.userName != null ? this.userName.equals(usr.userName): usr.userName ==null;

    }
}
