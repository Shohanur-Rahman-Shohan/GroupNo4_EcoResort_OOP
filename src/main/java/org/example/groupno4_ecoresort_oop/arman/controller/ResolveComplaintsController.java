package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;

public class ResolveComplaintsController
{
    @javafx.fxml.FXML
    private TextField confirmationTextField;
    @javafx.fxml.FXML
    private TableColumn complaintListTC;
    @javafx.fxml.FXML
    private TableView outputTableView;
    @javafx.fxml.FXML
    private TextField checkComplaintIdTextField;
    @javafx.fxml.FXML
    private TableColumn complaintTypeTC;
    @javafx.fxml.FXML
    private TextArea messageGMTextAArea;
    @javafx.fxml.FXML
    private TableColumn complaintIdTC;
    @javafx.fxml.FXML
    private TableColumn statusTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void checkButtonOnAction(ActionEvent actionEvent) {
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