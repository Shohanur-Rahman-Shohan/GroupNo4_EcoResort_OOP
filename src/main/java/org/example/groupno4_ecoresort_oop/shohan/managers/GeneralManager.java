package org.example.groupno4_ecoresort_oop.shohan.managers;

import org.example.groupno4_ecoresort_oop.user.User;

import java.io.Serializable;

public class GeneralManager extends User implements Serializable {

    public GeneralManager(String name, String email, String password, int id, int phoneNumber, String userType) {
        super(name, email, password, id, phoneNumber, "GeneralManager");
    }

    @Override
    public String getRoleDescription() {
        return "Responsible for Managing And OverViewing The Resorts Activity.";
    }
}


