
package org.example.groupno4_ecoresort_oop.nigar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;

import java.io.IOException;

 public class LaunchCampignController {


    @FXML
    private Button launchcampign;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private TextField campaignNameField;

    @FXML
    private TextField budgetField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField statusField;

    @FXML
    private TextField categoryField;


    Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    void initialize() {

    }


    @FXML
    public void switchScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1280, 720);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
