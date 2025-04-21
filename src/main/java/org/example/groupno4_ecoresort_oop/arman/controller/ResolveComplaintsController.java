package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.Complaint;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.util.List;

public class ResolveComplaintsController
{
    @javafx.fxml.FXML
    private TextField confirmationTextField;
    @javafx.fxml.FXML
    private TableView<Complaint> outputTableView;
    @javafx.fxml.FXML
    private TextField checkComplaintIdTextField;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> complaintTypeTC;
    @javafx.fxml.FXML
    private TextArea messageGMTextAArea;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> complaintIdTC;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> statusTC;
    private List<Complaint> complaintList;
    private Complaint selectedComplaint;

    @javafx.fxml.FXML
    public void initialize() {
        complaintIdTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        complaintTypeTC.setCellValueFactory(new PropertyValueFactory<>("type"));

        this.complaintList = BinaryFileHelper.readAllObjects(new File("Data/arman/complaints.bin"));
        outputTableView.getItems().addAll(complaintList);

    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
        if (selectedComplaint == null) {
            return;
        }
        selectedComplaint.setStatus("Resolved");
        BinaryFileHelper.writeAllObjects(new File("Data/arman/complaints.bin"), complaintList);
        outputTableView.getItems().clear();
        outputTableView.getItems().addAll(complaintList);
        confirmationTextField.setText("Updated");
    }

    @javafx.fxml.FXML
    public void checkButtonOnAction(ActionEvent actionEvent) {
        for ( Complaint c : complaintList ) {
            if (c.getId().equals(checkComplaintIdTextField.getText())){
                selectedComplaint = c;
                confirmationTextField.setText("Approved");
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void messageButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("arman/ACDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}