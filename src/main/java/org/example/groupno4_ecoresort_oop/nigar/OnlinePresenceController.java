package org.example.groupno4_ecoresort_oop.nigar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;

import java.io.IOException;

public class OnlinePresenceController {

    @FXML
    private Button start;

    @FXML
    private Button back;

    @FXML
    private TextField titleField;

    @FXML
    private TextField contentField;

    @FXML
    private TextField urlField;

    Stage stage = HelloApplication.getPrimaryStage();

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

    @FXML
    private void switch1(ActionEvent event) {
        switchScene("/org/example/groupno4_ecoresort_oop/nigar/DashBoard.fxml");
    }

    @FXML
    void initialize() {

    }
}



