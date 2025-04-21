package org.example.groupno4_ecoresort_oop.nigar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;

import java.io.IOException;

public class DashboardController {

    public static Stage getPrimaryStage() {
        return null;
    }

    @FXML
    void initialize() {

    }


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
    private void switchscene1(ActionEvent event) {
        switchScene("nigar.controller/Housekeepingsupervisor.fxml");

    }

    @FXML
    private void button(ActionEvent event) {
    }
}

