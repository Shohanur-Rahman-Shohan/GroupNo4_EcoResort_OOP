package org.example.groupno4_ecoresort_oop.arman;

import org.example.groupno4_ecoresort_oop.user.User;

import java.io.Serializable;

public class ActivityCoordinator extends User implements Serializable {

    // Constructor to initialize the Activity Coordinator object
    public ActivityCoordinator(String name, String email, String password, int id, int phoneNumber) {
        super(name, email, password, id, phoneNumber, "ActivityCoordinator");
    }

    // Overriding the abstract method from User class
    @Override
    public String getRoleDescription() {
        return "Responsible for coordinating activities and events at the eco-resort.";
    }
}
