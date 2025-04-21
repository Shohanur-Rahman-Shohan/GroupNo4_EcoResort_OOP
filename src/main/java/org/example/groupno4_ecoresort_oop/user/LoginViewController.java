package org.example.groupno4_ecoresort_oop.user;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.ActivityCoordinator;
import org.example.groupno4_ecoresort_oop.arman.MaintenanceTechnician;
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

    private List<User> users;

    @javafx.fxml.FXML
    public void initialize() {
        // Populate user type combo box
        userType_CB.getItems().addAll("ActivityCoordinator", "MaintenanceTechnician","GeneralManager","FinanceManager");
        showPassword_L.setOpacity(0); // Initially hide password label
    }

    @javafx.fxml.FXML
    public void showPassword_OA(ActionEvent actionEvent) {
        // Show or hide the password based on the checkbox state
        if (showPassword_CB.isSelected()) {
            password_PF.setStyle("-fx-text-fill: black;");
            password_PF.setPromptText(password_PF.getText());
            password_PF.setText(""); // Clear the password text to show plain text
        } else {
            password_PF.setPromptText("********");
            password_PF.setText(""); // Clear the current text to be masked
        }
    }

    @javafx.fxml.FXML
    public void signUp_OA(ActionEvent actionEvent) {
        // Navigate to the sign-up page
        try {
            SceneSwitcher.switchTo("user/SignUp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void loginContinue_OA(ActionEvent actionEvent) throws IOException {
        // Capture email, password, and user type
        String email = email_TF.getText();
        String password = password_PF.getText();
        String userType = userType_CB.getValue();

        // Validate that the fields are not empty
        if (email.isEmpty() || password.isEmpty() || userType == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        // Load users from the binary file
        File file = new File("Data/arman/users.bin");
        users = BinaryFileHelper.readAllObjects(file);

        boolean isValidUser = false;
        for (User user : users) {
            // Debugging: Log the email, password, and user type being compared
            System.out.println("Comparing email: " + user.getEmail() + " with input: " + email);
            System.out.println("Comparing password: " + user.getPassword() + " with input: " + password);
            System.out.println("Comparing user type: " + user.getUserType() + " with input: " + userType);

            // Check if email, password, and user type match
            if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getUserType().equals(userType)) {
                isValidUser = true;

                // Redirect to the appropriate dashboard
                if (user instanceof ActivityCoordinator) {
                    SceneSwitcher.switchTo("arman/ACDashboard");
                } else if (user instanceof MaintenanceTechnician) {
                    SceneSwitcher.switchTo("arman/MTDashboard");

                }else if (user instanceof GeneralManager) {
                    SceneSwitcher.switchTo("user/DashBoard");
                }else if (user instanceof FinanceManager) {
                    SceneSwitcher.switchTo("user/DashBoard");
                }



                break;
            }
        }

        // If no valid user is found, show an error message
        if (!isValidUser) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid email, password, or user type.");
            alert.showAndWait();
        }
    }
}
