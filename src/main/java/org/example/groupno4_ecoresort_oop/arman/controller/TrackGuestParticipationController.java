package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.groupno4_ecoresort_oop.arman.TourSchedule;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.util.List;

public class TrackGuestParticipationController {
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

        List<TourSchedule> tourScheduleList = BinaryFileHelper.readAllObjects(new File("Data/arman/tourschedule.bin"));
        for (TourSchedule tourSchedule : tourScheduleList) {
            if (tourSchedule.getGuestId().equals(guestId)) {
                outputDisplayTextArea.setText("Participation Details for Guest ID: " + guestId + "\n" + tourSchedule.toString() + "\n");
                return;
            }
        }
    }

    @javafx.fxml.FXML
    public void BackButtonOnAction(ActionEvent actionEvent) {

    }
}
