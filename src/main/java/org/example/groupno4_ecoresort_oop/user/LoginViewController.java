package org.example.groupno4_ecoresort_oop.user;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.Sadman.user.Guest;
import org.example.groupno4_ecoresort_oop.Sadman.user.Receptionist;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.ActivityCoordinator;
import org.example.groupno4_ecoresort_oop.arman.MaintenanceTechnician;
import org.example.groupno4_ecoresort_oop.nigar.users.HousekeepingSupervisor;
import org.example.groupno4_ecoresort_oop.nigar.users.MarketingAndSalesManager;
import org.example.groupno4_ecoresort_oop.shohan.managers.FinanceManager;
import org.example.groupno4_ecoresort_oop.shohan.managers.GeneralManager;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoginViewController {

    @javafx.fxml.FXML
    private PasswordField password_PF;
    @javafx.fxml.FXML
    private CheckBox showPassword_CB;
    @javafx.fxml.FXML
    private TextField email_TF;
    @javafx.fxml.FXML
    private Label showPassword_L;
    @javafx.fxml.FXML
    private ComboBox<String> userType_CB;




    public static User loggedInUser; // dashboard related




    @javafx.fxml.FXML
    public void initialize() {
        userType_CB.getItems().addAll("GeneralManager", "FinanceManager", "ActivityCoordinator", "MaintenanceTechnician", "HousekeepingSupervisor", "MarketingAndSalesManager", "Receptionist", "Guest");
        showPassword_L.setOpacity(0);
    }

    @javafx.fxml.FXML
    public void showPassword_OA(ActionEvent actionEvent) {
        if (showPassword_CB.isSelected()) {
            showPassword_L.setText(password_PF.getText());
            showPassword_L.setOpacity(1);
        } else {
            showPassword_L.setOpacity(0);
        }
    }

    @javafx.fxml.FXML
    public void signUp_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("user/SignUp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void loginContinue_OA(ActionEvent actionEvent) throws IOException {
        String email = email_TF.getText();
        String password = password_PF.getText();
        String userType = userType_CB.getValue();

        if (email.isEmpty() || password.isEmpty() || userType == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        File usersFile = new File("Data/users.bin");
        File guestsFile = new File("Data/guests.bin");
        File allUsersFile = new File("Data/allTypeUsers.bin");

        List<User> users = BinaryFileHelper.readAllObjects(usersFile);
        List<User> guests = BinaryFileHelper.readAllObjects(guestsFile);
        users.addAll(guests);
        BinaryFileHelper.writeAllObjects(allUsersFile, users);
        users = BinaryFileHelper.readAllObjects(allUsersFile);

        boolean isValidUser = false;
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getUserType().equals(userType)) {
                isValidUser = true;


                if (user instanceof ActivityCoordinator) {
                    SceneSwitcher.switchTo("arman/ACDashboard");
                } else if (user instanceof MaintenanceTechnician) {
                    SceneSwitcher.switchTo("arman/MTDashboard");


                } else if (user instanceof GeneralManager || user instanceof FinanceManager) {
                    loggedInUser = user;
                    SceneSwitcher.switchTo("user/DashBoard");


                } else if (user instanceof HousekeepingSupervisor) {
                    SceneSwitcher.switchTo("nigar/Controller/DashBoard");
                } else if (user instanceof MarketingAndSalesManager) {
                    SceneSwitcher.switchTo("nigar/Controller/DashBoard");


                } else if (user instanceof Receptionist) {
                    SceneSwitcher.switchTo("Sadman/Guest/guestDashboard");
                } else if (user instanceof Guest) {
                    SceneSwitcher.switchTo("Sadman/Receptionist/receptionistDashboard");
                }

                break;
            }
        }

        if (!isValidUser) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid email, password, or user type.");
            alert.showAndWait();
        }
    }
}
