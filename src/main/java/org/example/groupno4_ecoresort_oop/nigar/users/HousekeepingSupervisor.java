package org.example.groupno4_ecoresort_oop.nigar.users;

import org.example.groupno4_ecoresort_oop.user.User;

import java.io.Serializable;

public class HousekeepingSupervisor extends User implements Serializable {

    public HousekeepingSupervisor(String name, String email, String password, int id, int phoneNumber) {
        super(name, email, password, id, phoneNumber, "HousekeepingSupervisor");
    }

    @Override
    public String getRoleDescription() {
        return "Responsible for supervising all housekeeping staff and maintaining cleanliness standards.";
    }
}
