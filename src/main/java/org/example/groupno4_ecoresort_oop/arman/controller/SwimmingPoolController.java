package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;

public class SwimmingPoolController
{
    @javafx.fxml.FXML
    private TextField remarksTextField;
    @javafx.fxml.FXML
    private TableColumn remarksTC;
    @javafx.fxml.FXML
    private TextField chlorinLevelTextField;
    @javafx.fxml.FXML
    private TableColumn phLevelTC;
    @javafx.fxml.FXML
    private TableColumn testDateTC;
    @javafx.fxml.FXML
    private TextField phLevelTextField;
    @javafx.fxml.FXML
    private TableView swimmingPoolTableView;
    @javafx.fxml.FXML
    private TableColumn chlorinTC;
    @javafx.fxml.FXML
    private DatePicker testDateDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void BackButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("user/MTDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void saveTestResultButtonOnAction(ActionEvent actionEvent) {
    }
}