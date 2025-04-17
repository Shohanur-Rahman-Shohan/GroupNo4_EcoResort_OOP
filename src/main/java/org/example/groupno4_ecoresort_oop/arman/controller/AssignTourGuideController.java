package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;

public class AssignTourGuideController
{
    @javafx.fxml.FXML
    private TableColumn tourDayTC;
    @javafx.fxml.FXML
    private TableView outputTableView;
    @javafx.fxml.FXML
    private ComboBox availableGuideCombobox;
    @javafx.fxml.FXML
    private TextField tourIdTextField;
    @javafx.fxml.FXML
    private TableColumn tourIdTC;
    @javafx.fxml.FXML
    private TableColumn tourGuideTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadAvailableGuideOnAction(ActionEvent actionEvent) {
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