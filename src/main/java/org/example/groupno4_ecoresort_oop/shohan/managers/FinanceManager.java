package org.example.groupno4_ecoresort_oop.shohan.managers;

import org.example.groupno4_ecoresort_oop.user.User;

import java.io.Serializable;

public class FinanceManager extends User implements Serializable {

    public FinanceManager(String name, String email, String password, int id, int phoneNumber, String userType) {
        super(name, email, password, id, phoneNumber, "FinanceManager");
    }

    @Override
    public String getRoleDescription() {
        return "Responsible for Managing The Resorts Finance.";
    }
}