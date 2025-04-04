package org.example.groupno4_ecoresort_oop;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.shohan.Manager;

import java.io.IOException;
import java.util.ArrayList;

public class LoginViewController
{
    @javafx.fxml.FXML
    private PasswordField password_PF;
    @javafx.fxml.FXML
    private CheckBox showPassword_CB;
    @javafx.fxml.FXML
    private TextField email_TF;
    @javafx.fxml.FXML
    private Label showPassword_L;



    // Database
    private ArrayList<Manager> managers;

    public void setDataBase(ArrayList<Manager> managers) {
        this.managers = managers;
    }





    @javafx.fxml.FXML
    public void initialize() {
        showPassword_L.setOpacity(0);
    }

    @javafx.fxml.FXML
    public void showPassword_OA(ActionEvent actionEvent) {
        if (showPassword_CB.isSelected()) {
            String password = password_PF.getText();
            showPassword_L.setText(password);
            showPassword_L.setOpacity(100);
        } else {
            showPassword_L.setText("");
            showPassword_L.setOpacity(0);
        }
    }






    @javafx.fxml.FXML
    public void signUp_OA(ActionEvent actionEvent) {
    }














    @javafx.fxml.FXML
    public void loginContinue_OA(ActionEvent actionEvent) throws IOException {
        String email = email_TF.getText();
        String password = password_PF.getText();

        boolean isValidEmailAndPassword = Manager.validateEmailAndPassword(email, password);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (!isValidEmailAndPassword) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Email or Password");
            alert.setContentText("Please use valid email and password. Password must be longer than 6, and must contain a number");
            alert.showAndWait();
            return;
        }

        Manager currentManager = Manager.verifyManager(managers, email, password);
        if (currentManager == null) {
            alert.setHeaderText("Invalid Email or Password");
            alert.setContentText("Please use valid email and password.");
            alert.showAndWait();
            return;
        }

        email_TF.clear();
        password_PF.clear();

        Scene scene = ((Button) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();


        try {
            SceneSwitcher.switchTo("GMDashboard");
        } catch (Exception e) {
        }
    }
}