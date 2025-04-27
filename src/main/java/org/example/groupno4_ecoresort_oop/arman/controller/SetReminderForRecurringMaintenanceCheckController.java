package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;

public class SetReminderForRecurringMaintenanceCheckController
{
    @javafx.fxml.FXML
    private Label maintenanceStatusCheckLabel;
    @javafx.fxml.FXML
    private TextField requestIdTextField;
    @javafx.fxml.FXML
    private DatePicker setReminderDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void setReminderButtonOnAction(ActionEvent actionEvent) {
        String requestId = requestIdTextField.getText();
        if (requestId == null || requestId.isEmpty()) {
            maintenanceStatusCheckLabel.setText("Please enter a Request ID.");
            return;
        }
        if (setReminderDatePicker.getValue() == null) {
            maintenanceStatusCheckLabel.setText("Please select a reminder date.");
            return;
        }
        if (setReminderDatePicker.getValue().isBefore(java.time.LocalDate.now())) {
            maintenanceStatusCheckLabel.setText("Reminder date cannot be in the past.");
            return;
        }
        maintenanceStatusCheckLabel.setText("Reminder set successfully for Request ID: " + requestId);
    }



    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("arman/MTDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}