package org.example.groupno4_ecoresort_oop.shohan.managers;

import java.util.ArrayList;

public abstract class Manager {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String type;


    public Manager() {
    }


    public Manager(int id, String firstName, String lastName, String email, String password, String phoneNumber, String type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }








    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }








    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type='" + type + '\'' +
                '}';
    }










    public static Manager verifyManager(ArrayList<Manager> managers, String email, String password) {
        Manager currManager = null;
        for (Manager m : managers) {
            if (m.getEmail().equals(email) && m.getPassword().equals(password)) {
                currManager = m;
                break;
            }
        }

        return currManager;
    }

    public static boolean validateEmailAndPassword(String email, String password) {
        if (!email.contains("@")) {
            return false;
        }

        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        boolean hasNumber = false;
        for (String number : numbers) {
            if (password.contains(number)) {
                hasNumber = true;
                break;
            }
        }

        return hasNumber && password.length() >= 5;
    }
}
