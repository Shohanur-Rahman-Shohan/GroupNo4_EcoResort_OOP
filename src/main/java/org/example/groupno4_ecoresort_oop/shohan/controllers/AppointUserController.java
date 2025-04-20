package org.example.groupno4_ecoresort_oop.shohan.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.Sadman.user.Receptionist;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.ActivityCoordinator;
import org.example.groupno4_ecoresort_oop.arman.MaintenanceTechnician;
import org.example.groupno4_ecoresort_oop.nigar.users.HousekeepingSupervisor;
import org.example.groupno4_ecoresort_oop.nigar.users.MarketingAndSalesManager;
import org.example.groupno4_ecoresort_oop.user.User;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointUserController
{
    @FXML
    private TextField lastName_TF;
    @FXML
    private ComboBox<String> userType_CB;
    @FXML
    private TextField salary_TF;
    @FXML
    private DatePicker joiningDate_DP;
    @FXML
    private TextField phoneNumber_TF;
    @FXML
    private ComboBox<String> gender_CB;
    @FXML
    private TextField email_TF;
    @FXML
    private TextField firstName_TF;
    @FXML
    private PasswordField password_TF;







    @FXML
    public void initialize() {
        userType_CB.getItems().setAll("FinanceManager","ActivityCoordinator","MaintenanceTechnician","HousekeepingSupervisor","MarketingAndSalesManager","Receptionist");
        gender_CB.getItems().setAll("Male","Female");
    }



    ArrayList<User> newUser= new ArrayList<>();





    @FXML
    public void backButton_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("user/DashBoard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    @FXML
    public void addUser_OA(ActionEvent actionEvent) {
        String firstName=firstName_TF.getText();
        String lastName= lastName_TF.getText();
        String gender= gender_CB.getValue();
        String userType= userType_CB.getValue();
        LocalDate joiningDate= joiningDate_DP.getValue();

        int salary= 0;
        try {
            salary = Integer.parseInt(salary_TF.getText());
        } catch (NumberFormatException e){}


        String email= email_TF.getText();

        int phoneNumber= 0;
        try {
            phoneNumber = Integer.parseInt(phoneNumber_TF.getText());
        } catch (NumberFormatException e) {}

        String password= password_TF.getText();

        
        
        


        if (firstName.isEmpty() || lastName.isEmpty() || joiningDate==null || salary <=0 || email.isEmpty() || password.isEmpty() || phoneNumber <= 0 || userType == null || gender == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all fields properly.");
            alert.showAndWait();
            return;
        }
        if (phoneNumber <=999999999) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Phone Number.");
            alert.showAndWait();
            return;
        }




        
        int userId=generateUserId();
        
        User newUser = null;
        if (userType.equalsIgnoreCase("ActivityCoordinator")) {
            newUser = new ActivityCoordinator(firstName, email, password, userId, phoneNumber);
        } else if (userType.equalsIgnoreCase("MaintenanceTechnician")){
            newUser = new MaintenanceTechnician(firstName, email, password, userId, phoneNumber);

        } else if (userType.equalsIgnoreCase("HousekeepingSupervisor")) {
            newUser = new HousekeepingSupervisor(firstName, email, password, userId, phoneNumber);
        } else if (userType.equalsIgnoreCase("MarketingAndSalesManager")) {
            newUser = new MarketingAndSalesManager(firstName, email, password, userId, phoneNumber);

        } else if (userType.equalsIgnoreCase("Receptionist")) {
            newUser = new Receptionist(firstName, email, password, userId, phoneNumber);
        }







        File file = new File("Data/users.bin");        // Save the user object to the binary file

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







    private void clearFields() {
        firstName_TF.clear();
        lastName_TF.clear();
        email_TF.clear();
        phoneNumber_TF.clear();
        salary_TF.clear();
        password_TF.clear();
        gender_CB.getSelectionModel().clearSelection();
        userType_CB.getSelectionModel().clearSelection();
        joiningDate_DP.setValue(null);
    }



    private int generateUserId() {
        File file = new File("Data/users.bin");
        List<User> users = BinaryFileHelper.readAllObjects(file);
        int maxId = 1112;                                                 // First generated ID becomes 1113

        for (User user : users) {
            if (user.getId() > maxId) {
                maxId = user.getId();
            }
        }

        return maxId + 1;
    }

}