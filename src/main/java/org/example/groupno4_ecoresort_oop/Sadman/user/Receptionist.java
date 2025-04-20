package org.example.groupno4_ecoresort_oop.Sadman.user;

import org.example.groupno4_ecoresort_oop.user.User;

import java.io.Serializable;

public class Receptionist extends User implements Serializable {
    public Receptionist(String name, String email, String password, int id, int phoneNumber) {
        super(name, email, password, id, phoneNumber, "Receptionist");
    }


    // Override getRoleDescription method
    @Override
    public String getRoleDescription() {
        return "Responsible for supervising marketing and sales strategies, including promotions and customer engagement.";
    }
}
