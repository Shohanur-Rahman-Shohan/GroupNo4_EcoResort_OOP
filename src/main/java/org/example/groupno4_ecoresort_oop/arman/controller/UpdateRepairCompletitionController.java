package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;

public class UpdateRepairCompletitionController
{
    @javafx.fxml.FXML
    private TableColumn locationTC;
    @javafx.fxml.FXML
    private TableColumn typeTC;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private TableView outputCompletitionTableView;
    @javafx.fxml.FXML
    private TableColumn requestIdTC;
    @javafx.fxml.FXML
    private TextField requestIdTextField;
    @javafx.fxml.FXML
    private TableColumn requestDateTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateRepairCompletitionDetailsButtonOnAction(ActionEvent actionEvent) {
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