package org.example.groupno4_ecoresort_oop.Sadman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GD {


    @FXML
    private Label getGuestLabel;

    @FXML
    private void switchToAvailableRooms() throws Exception {
        loadScene("Guest/AvailableRoomView.fxml");
    }

    @FXML
    private void switchToMakeReservation() throws Exception {
        loadScene("Guest/MakeReservationView.fxml");
    }

    @FXML
    private void switchToModifyReservation() throws Exception {
        loadScene("Guest/ModifyReservationView.fxml");
    }

    @FXML
    private void switchToFeedback() throws Exception {
        loadScene("Guest/FeedbackView.fxml");
    }

    private void loadScene(String fxmlFile) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage) getGuestLabel.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}