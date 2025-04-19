package org.example.groupno4_ecoresort_oop.user;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String name;
    private String email;
    private String password;
    private int id;
    private int phoneNumber;
    private String userType;

    // Constructor to initialize the user
    public User(String name, String email, String password, int id, int phoneNumber, String userType) {
        this.name = name;
        this.email = email;
        this.password = password; // In practice, you should hash this password
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }

    // Getter methods for the attributes
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserType() {
        return userType;
    }

    // Abstract method that must be implemented by subclasses
    public abstract String getRoleDescription();

    // Overriding toString method for a clean string representation
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", userType='" + userType + '\'' +
                '}';
    }
}
