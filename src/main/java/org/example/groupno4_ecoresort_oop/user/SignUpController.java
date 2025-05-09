package org.example.groupno4_ecoresort_oop.user;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.Sadman.user.Guest;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
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
    private Label showPassword_L;
    @javafx.fxml.FXML
    private CheckBox showPassword_CB;


    @javafx.fxml.FXML
    public void initialize() {
        showPassword_L.setOpacity(0);
        userType_CB.getItems().addAll("Guest");
        gender_CB.getItems().addAll("Male", "Female");
    }

    @javafx.fxml.FXML
    public void signUp_OA(ActionEvent actionEvent) {
        String firstName = firstName_TF.getText();
        String lastName = lastName_TF.getText();
        String email = email_TF.getText();
        String password = password_TF.getText();

        int phoneNumber = 0;
        try {
            phoneNumber = Integer.parseInt(phoneNumber_TF.getText());
        } catch (NumberFormatException e) {}

        String userType = userType_CB.getValue();  // Get selected User Type
        String gender = gender_CB.getValue();      // Get selected Gender



        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || phoneNumber <= 0 || userType == null || gender == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all fields properly.");
            alert.showAndWait();
            return;
        }
        if (phoneNumber <= 999999999) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Phone Number.");
            alert.showAndWait();
            return;
        }



        int userId = generateUserId();

        User newUser;
        if (userType.equalsIgnoreCase("Guest")) {
            newUser = new Guest(firstName, email, password, userId, phoneNumber);



            File file = new File("Data/guests.bin");

            try {
                List<User> users = BinaryFileHelper.readAllObjects(file);
                users.add(newUser);

                // Save the updated list back to the file
                BinaryFileHelper.writeAllObjects(file, users);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Guest Account successfully created.");
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
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("user/LoginView");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void clearFields() {
        firstName_TF.clear();
        lastName_TF.clear();
        email_TF.clear();
        phoneNumber_TF.clear();
        userType_CB.getSelectionModel().clearSelection();
        gender_CB.getSelectionModel().clearSelection();
        password_TF.clear();
    }



    private int generateUserId() {
        File file = new File("Data/guests.bin");
        List<User> users = BinaryFileHelper.readAllObjects(file);
        int maxId = 0;



        for (User user : users) {
            if (user.getId() > maxId) {
                maxId = user.getId();
            }
        }
        return maxId + 1;
    }











    @javafx.fxml.FXML
    public void showPassword_OA(ActionEvent actionEvent) {
        if (showPassword_CB.isSelected()) {
            showPassword_L.setText(password_TF.getText());
            showPassword_L.setOpacity(1);
        } else {
            showPassword_L.setOpacity(0);
        }
    }
}
