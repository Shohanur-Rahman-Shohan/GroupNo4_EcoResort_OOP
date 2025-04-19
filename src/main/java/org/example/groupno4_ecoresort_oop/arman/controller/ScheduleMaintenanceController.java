package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.RepairRequest;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class ScheduleMaintenanceController {

    @FXML private TableColumn<RepairRequest, String> locationTC;
    @FXML private TableColumn<RepairRequest, String> typeTC;
    @FXML private TableColumn<RepairRequest, String> statusTC;
    @FXML private TableColumn<RepairRequest, String> requestIdTC;
    @FXML private TableColumn<RepairRequest, LocalDate> requestDateTC;
    @FXML private TableView<RepairRequest> ScheduleMaintenanceTableView;
    @FXML private TextArea outputTextArea;
    @FXML private TextField checkIDTextField;

    private final String FILE_PATH = "repair_requests.bin";
    private ObservableList<RepairRequest> requestList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        requestIdTC.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        locationTC.setCellValueFactory(new PropertyValueFactory<>("location"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        requestDateTC.setCellValueFactory(new PropertyValueFactory<>("requestDate"));

        loadFromFile();
        ScheduleMaintenanceTableView.setItems(requestList);
    }

    @FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String searchId = checkIDTextField.getText();
        if (searchId == null || searchId.trim().isEmpty()) {
            outputTextArea.setText("Please enter a Request ID to search.");
            return;
        }

        for (RepairRequest req : requestList) {
            if (req.getRequestId().equalsIgnoreCase(searchId.trim())) {
                outputTextArea.setText(
                        "Request ID: " + req.getRequestId() + "\n" +
                                "Location: " + req.getLocation() + "\n" +
                                "Type: " + req.getType() + "\n" +
                                "Status: " + req.getStatus() + "\n" +
                                "Request Date: " + req.getRequestDate() + "\n" +
                                "Emergency: " + req.getEmergency()
                );
                return;
            }
        }
        outputTextArea.setText("No repair request found with Request ID: " + searchId);
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
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            ArrayList<RepairRequest> list = (ArrayList<RepairRequest>) in.readObject();
            requestList.setAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}