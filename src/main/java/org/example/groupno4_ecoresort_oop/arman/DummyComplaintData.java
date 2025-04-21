package org.example.groupno4_ecoresort_oop.arman;

import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.util.ArrayList;

public class DummyComplaintData {

    public static void main(String[] args) {
            ArrayList<Complaint> complaints = new ArrayList<>();

            complaints.add(new Complaint("C001", "No guide showed up", "Eco-tour", "Pending"));
            complaints.add(new Complaint("C002", "Broken bike", "Adventure Sport", "Pending"));
            complaints.add(new Complaint("C003", "Late start of tour", "Eco-tour", "Resolved"));
            complaints.add(new Complaint("C004", "Unfriendly staff", "General", "Pending"));
            complaints.add(new Complaint("C005", "Room not cleaned", "Accommodation", "Resolved"));
            complaints.add(new Complaint("C006", "No vegetarian meal", "Food", "Pending"));
            complaints.add(new Complaint("C007", "Tour was too short", "Eco-tour", "Pending"));
            complaints.add(new Complaint("C008", "Kayak was damaged", "Adventure Sport", "Pending"));
            complaints.add(new Complaint("C009", "Noise at night", "Accommodation", "Resolved"));
            complaints.add(new Complaint("C010", "No hot water", "Accommodation", "Pending"));

            BinaryFileHelper.writeAllObjects(new File("Data/arman/complaints.bin"), complaints);
        }


    }
