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
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageRepairRequestController {

    @FXML private TextField requestIdTextField;
    @FXML private TextField locationTextField;
    @FXML private ComboBox<String> typeComboBox;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private DatePicker requestDateDatePicker;
    @FXML private ComboBox<String> emergencyComboBox;
    @FXML private TableView<org.example.groupno4_ecoresort_oop.arman.RepairRequest> outputTableView;
    @FXML private TableColumn<RepairRequest, String> RequestIdTC;
    @FXML private TableColumn<RepairRequest, String> locationTC;
    @FXML private TableColumn<RepairRequest, String> typeTC;
    @FXML private TableColumn<RepairRequest, String> statusTC;
    @FXML private TableColumn<RepairRequest, LocalDate> requestDateTC;
    @FXML private TableColumn<RepairRequest, String> emergencyTC;
    @FXML private TextField updaterequestIdTextField;
    @FXML private ComboBox<String> updatestatusComboBox;
    @FXML private ComboBox<String> updateemergencyComboBox;

    private final String FILE_PATH = "repair_requests.bin";
    private ObservableList<RepairRequest> requestList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        typeComboBox.setItems(FXCollections.observableArrayList("Plumbing", "Electrical", "Painting", "Furniture", "AC Repair"));
        statusComboBox.setItems(FXCollections.observableArrayList("Pending", "In Progress", "Completed"));
        emergencyComboBox.setItems(FXCollections.observableArrayList("Yes", "No"));
        updatestatusComboBox.setItems(FXCollections.observableArrayList("Pending", "In Progress", "Completed"));
        updateemergencyComboBox.setItems(FXCollections.observableArrayList("Yes", "No"));

        RequestIdTC.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        locationTC.setCellValueFactory(new PropertyValueFactory<>("location"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        requestDateTC.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
        emergencyTC.setCellValueFactory(new PropertyValueFactory<>("emergency"));

        loadFromFile();
        outputTableView.setItems(requestList);
    }

    @FXML
    public void addRequestButtonOnAction(ActionEvent event) {
        String id = requestIdTextField.getText();
        String location = locationTextField.getText();
        String type = typeComboBox.getValue();
        String status = statusComboBox.getValue();
        LocalDate date = requestDateDatePicker.getValue();
        String emergency = emergencyComboBox.getValue();

        if (id.isEmpty() || location == null || type == null || status == null || date == null || emergency == null) {
            showAlert("All fields must be filled!");
            return;
        }

        RepairRequest request = new RepairRequest(id, location, type, status, date, emergency);
        requestList.add(request);
        saveToFile();
        clearInputFields();
    }

    @FXML
    public void updateStatusButtonOnAction(ActionEvent event) {
        String id = updaterequestIdTextField.getText();
        String newStatus = updatestatusComboBox.getValue();
        String newEmergency = updateemergencyComboBox.getValue();

        for (RepairRequest req : requestList) {
            if (req.getRequestId().equals(id)) {
                if (newStatus != null) req.setStatus(newStatus);
                if (newEmergency != null) req.setEmergency(newEmergency);
                outputTableView.refresh();
                saveToFile();
                return;
            }
        }
        showAlert("Request ID not found!");
    }

    @FXML
    public void deleteRequestButtonOnAction(ActionEvent event) {
        String id = updaterequestIdTextField.getText();
        boolean removed = requestList.removeIf(req -> req.getRequestId().equals(id));
        if (removed) {
            saveToFile();
            outputTableView.refresh();
        } else {
            showAlert("Request ID not found!");
        }
    }

    @FXML
    public void backButtonOnAction(ActionEvent event) {
        try {
            SceneSwitcher.switchTo("arman/MTDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearInputFields() {
        requestIdTextField.clear();
        locationTextField.clear();
        typeComboBox.setValue(null);
        statusComboBox.setValue(null);
        requestDateDatePicker.setValue(null);
        emergencyComboBox.setValue(null);
    }

    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(new ArrayList<>(requestList));
        } catch (IOException e) {
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

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}