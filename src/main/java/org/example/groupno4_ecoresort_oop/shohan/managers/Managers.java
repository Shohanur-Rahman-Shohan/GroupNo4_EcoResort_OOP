package org.example.groupno4_ecoresort_oop.shohan.managers;

import org.example.groupno4_ecoresort_oop.user.User;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.util.List;

public class Managers {

    public static void addDefaultManagers() {

        File file = new File("Data/users.bin");

        File directory = file.getParentFile();                         // Ensure the directory exists
        if (directory != null && !directory.exists()) {
            directory.mkdirs();
        }





        List<User> users = BinaryFileHelper.readAllObjects(file);               // Read existing users

        boolean gmExists = false;
        boolean fmExists = false;

        for (User user : users) {
            if (user instanceof GeneralManager) {
                gmExists = true;
            } else if (user instanceof FinanceManager) {
                fmExists = true;
            }
        }




        // Only add managers if they don't exist
        if (!gmExists) {
            User newGM = new GeneralManager("Shohan", "gm@gmail.com", "12345", 1111, 1749581973, "GeneralManager");
            users.add(newGM);
        }
        if (!fmExists) {
            User newFM = new FinanceManager("Shohan", "fm@gmail.com", "12345", 2222, 1749581973, "FinanceManager");
            users.add(newFM);
        }

        // Save updated list
        BinaryFileHelper.writeAllObjects(file, users);
    }
}
