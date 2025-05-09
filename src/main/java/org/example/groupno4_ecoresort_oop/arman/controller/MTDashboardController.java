package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;

import javafx.event.Event;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;

public class MTDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void monthlyMaintenanceButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/MonthlyReport");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @javafx.fxml.FXML
    public void repairRequestButtonONClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/ManageRepairRequest");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void setReminderButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/SetReminderForRecurringMaintenanceCheck");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void swimmingPoolButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/SwimmingPool");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void viewRepairRequestButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/ManageRepairRequest");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @javafx.fxml.FXML
    public void emergencyMaintenanceButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/EmergencyMaintenance");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void performScheduledMaintenanceButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/ScheduleMaintenance");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void assignRepairTasksButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/AssignRepairTask");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("user/LoginView");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}