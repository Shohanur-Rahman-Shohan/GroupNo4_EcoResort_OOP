package org.example.groupno4_ecoresort_oop.nigar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;

public class housekeepingdashboard {

    @FXML
    private void handleStartCleaningTask() {
        showMessage("Starting cleaning task...");
        switchScene("start_cleaning.fxml");
    }

    @FXML
    private void handleViewInventory() {
        showMessage("Viewing inventory...");
        switchScene("inventory.fxml");
    }

    @FXML
    private void handleViewSchedule() {
        showMessage("Opening staff schedule...");
        switchScene("schedule.fxml");
    }

    @FXML
    private void handleGuestRequests() {
        showMessage("Handling guest requests...");
        switchScene("guest_requests.fxml");
    }

    @FXML
    private void handleAssignTasks() {
        showMessage("Assigning tasks...");
        switchScene("assign_tasks.fxml");
    }

    @FXML
    private void handleQualityControl() {
        showMessage("Viewing quality control report...");
        switchScene("quality_control.fxml");
    }

    @FXML
    private void handleMaintenance() {
        showMessage("Reviewing maintenance...");
        switchScene("maintenance.fxml");
    }

    @FXML
    private void handleDailyReports() {
        showMessage("Generating daily report...");
        switchScene("daily_report.fxml");
    }

    private void switchScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Stage stage = (Stage) javafx.stage.Window.getWindows().get(0);
            stage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            showMessage("Error loading: " + fxmlFile);
        }
    }

    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Navigation");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
