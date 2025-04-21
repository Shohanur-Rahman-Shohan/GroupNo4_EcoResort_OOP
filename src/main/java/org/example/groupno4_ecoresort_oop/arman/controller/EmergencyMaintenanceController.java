package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.RepairRequest;

import java.io.*;
import java.util.ArrayList;

public class EmergencyMaintenanceController {

    @FXML private TableView<RepairRequest> outputTableView;
    @FXML private TableColumn<RepairRequest, String> requestIdTC;
    @FXML private TableColumn<RepairRequest, String> statusTC;
    @FXML private TableColumn<RepairRequest, String> emergencyTC;
    @FXML private TextField requestIdTextField;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private ComboBox<String> emergencyComboBox;

    private final String FILE_PATH = "repair_requests.bin";
    private ObservableList<RepairRequest> requestList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        requestIdTC.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        emergencyTC.setCellValueFactory(new PropertyValueFactory<>("emergency"));

        statusComboBox.setItems(FXCollections.observableArrayList("Pending", "In Progress", "Completed"));
        emergencyComboBox.setItems(FXCollections.observableArrayList("Yes", "No"));

        loadFromFile();
        outputTableView.setItems(requestList);
    }

    @FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
        String id = requestIdTextField.getText();
        String newStatus = statusComboBox.getValue();
        String newEmergency = emergencyComboBox.getValue();
        boolean found = false;
        for (RepairRequest req : requestList) {
            if (req.getRequestId().equals(id)) {
                if (newStatus != null) req.setStatus(newStatus);
                if (newEmergency != null) req.setEmergency(newEmergency);
                found = true;
                break;
            }
        }
        if (found) {
            saveToFile();
            outputTableView.refresh();
        } else {
            showAlert("Request ID not found!");
        }
    }
    @FXML
    public void filterButtonOnAction(ActionEvent actionEvent) {
        String id = requestIdTextField.getText();
        if (id.isEmpty()) {
            outputTableView.setItems(requestList); // Show all
        } else {
            ObservableList<RepairRequest> filteredList = FXCollections.observableArrayList();
            for (RepairRequest req : requestList) {
                if (req.getRequestId().equals(id)) {
                    filteredList.add(req);
                    break;
                }
            }
            outputTableView.setItems(filteredList);
        }
    }
    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("arman/MTDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            ArrayList<RepairRequest> list = (ArrayList<RepairRequest>) in.readObject();
            requestList.setAll(list);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(new ArrayList<>(requestList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}