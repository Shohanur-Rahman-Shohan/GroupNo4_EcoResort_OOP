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
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("user/MTDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}