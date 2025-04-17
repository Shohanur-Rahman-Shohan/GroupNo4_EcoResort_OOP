package org.example.groupno4_ecoresort_oop.arman;

import org.example.groupno4_ecoresort_oop.user.User;

public class ActivityCoordinator extends User {
    public ActivityCoordinator() {
    }

    public ActivityCoordinator(String name, String email, String password, int id, int phoneNumber) {
        super(name, email, password, id, phoneNumber);
    }

    @Override
    public String toString() {
        return "ActivityCoordinator{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
