package org.example.groupno4_ecoresort_oop.arman;

import org.example.groupno4_ecoresort_oop.user.User;

import java.io.Serializable;

public class MaintenanceTechnician extends User implements Serializable {

    public MaintenanceTechnician(String name, String email, String password, int id, int phoneNumber) {
        super(name, email, password, id, phoneNumber, "MaintenanceTechnician");
    }

    @Override
    public String getRoleDescription() {
        return "Responsible for maintaining and repairing equipment and facilities at the eco-resort.";
    }
}
