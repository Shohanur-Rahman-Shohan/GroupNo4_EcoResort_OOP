package org.example.groupno4_ecoresort_oop.Sadman.user;

import org.example.groupno4_ecoresort_oop.user.User;

import java.io.Serializable;

public class Guest extends User implements Serializable {
    public Guest(String name, String email, String password, int id, int phoneNumber) {
        super(name, email, password, id, phoneNumber, "Guest");
    }


    @Override
    public String getRoleDescription() {
        return "Guests.";
    }
}
