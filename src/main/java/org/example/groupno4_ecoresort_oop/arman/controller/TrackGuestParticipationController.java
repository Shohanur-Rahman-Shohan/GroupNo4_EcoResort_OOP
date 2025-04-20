package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.TourSchedule;

public class TrackGuestParticipationController
{
    @javafx.fxml.FXML
    private TextArea outputDisplayTextArea;
    @javafx.fxml.FXML
    private TextField checkGuestIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void checkButtonOnAction(ActionEvent actionEvent) {
        String guestId = checkGuestIdTextField.getText();
        if (guestId.isEmpty()) {
            outputDisplayTextArea.setText("Please enter a Guest ID");
            return;
        }

//
//        if (exists) {
//            outputDisplayTextArea.setText("Guest with ID " + guestId + " has participated in tours.");
//        } else {
//            outputDisplayTextArea.setText("Guest with ID " + guestId + " has not participated in any tours.");
//        }
//    }
  }

    @javafx.fxml.FXML
    public void BackButtonOnAction(ActionEvent actionEvent) {

        try {
            SceneSwitcher.switchTo("arman/ACDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}