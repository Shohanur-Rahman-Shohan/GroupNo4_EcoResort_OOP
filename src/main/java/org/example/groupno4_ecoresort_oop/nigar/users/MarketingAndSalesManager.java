package org.example.groupno4_ecoresort_oop.nigar.users;

import org.example.groupno4_ecoresort_oop.user.User;

import java.io.Serializable;

public class MarketingAndSalesManager extends User implements Serializable {

    // Constructor
    public MarketingAndSalesManager(String name, String email, String password, int id, int phoneNumber) {
        super(name, email, password, id, phoneNumber, "MarketingAndSalesManager");
    }

    // Override getRoleDescription method
    @Override
    public String getRoleDescription() {
        return "Responsible for supervising marketing and sales strategies, including promotions and customer engagement.";
    }
}
