package org.example.groupno4_ecoresort_oop.user;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.ActivityCoordinator;
import org.example.groupno4_ecoresort_oop.arman.MaintenanceTechnician;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SignUpController {

    @javafx.fxml.FXML
    private TextField firstName_TF;
    @javafx.fxml.FXML
    private TextField lastName_TF;
    @javafx.fxml.FXML
    private TextField email_TF;
    @javafx.fxml.FXML
    private TextField phoneNumber_TF;
    @javafx.fxml.FXML
    private ComboBox<String> userType_CB;  // User Type ComboBox
    @javafx.fxml.FXML
    private ComboBox<String> gender_CB;    // Gender ComboBox
    @javafx.fxml.FXML
    private PasswordField password_TF;

    @javafx.fxml.FXML
    public void initialize() {
        userType_CB.getItems().addAll("ActivityCoordinator", "MaintenanceTechnician");
        gender_CB.getItems().addAll("Male", "Female");
    }

    @javafx.fxml.FXML
    public void signUp_OA(ActionEvent actionEvent) {
        String firstName = firstName_TF.getText();
        String lastName = lastName_TF.getText();
        String email = email_TF.getText();
        String password = password_TF.getText();
        int phoneNumber = 0;

        // Try to parse the phone number, catch invalid input
        try {
            phoneNumber = Integer.parseInt(phoneNumber_TF.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid phone number. Please enter a valid number.");
            alert.showAndWait();
            return;
        }

        String userType = userType_CB.getValue();  // Get selected User Type
        String gender = gender_CB.getValue();      // Get selected Gender

        // Validate the inputs
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || phoneNumber <= 0 || userType == null || gender == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        // Generate ID for the new user
        int userId = generateUserId();

        // Create the user object based on the user type
        User newUser;
        if (userType.equalsIgnoreCase("ActivityCoordinator")) {
            newUser = new ActivityCoordinator(firstName, email, password, userId, phoneNumber);
        } else {
            newUser = new MaintenanceTechnician(firstName, email, password, userId, phoneNumber);
        }

        // Save the user object to the binary file
        File file = new File("Data/arman/users.bin");

        try {
            // Read existing users from the file
            List<User> users = BinaryFileHelper.readAllObjects(file);

            // Add new user to the list
            users.add(newUser);

            // Save the updated list back to the file
            BinaryFileHelper.writeAllObjects(file, users);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Account successfully created.");
            alert.showAndWait();

            // Clear the input fields after successful sign-up
            clearFields();

            // After successful sign-up, redirect to the login page
            SceneSwitcher.switchTo("user/LoginView");
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error occurred while creating the account.");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        // Navigate back to the login page
        try {
            SceneSwitcher.switchTo("user/LoginView");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to clear the input fields
    private void clearFields() {
        firstName_TF.clear();
        lastName_TF.clear();
        email_TF.clear();
        phoneNumber_TF.clear();
        userType_CB.getSelectionModel().clearSelection();
        gender_CB.getSelectionModel().clearSelection();
        password_TF.clear();
    }

    // Method to generate a unique user ID
    private int generateUserId() {
        File file = new File("Data/arman/users.bin");
        List<User> users = BinaryFileHelper.readAllObjects(file);
        int maxId = 0;

        // Find the highest ID from existing users
        for (User user : users) {
            if (user.getId() > maxId) {
                maxId = user.getId();
            }
        }

        // Generate the next ID
        return maxId + 1;
    }
}
