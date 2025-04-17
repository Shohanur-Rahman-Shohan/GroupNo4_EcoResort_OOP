package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;

public class FeedbackAndSuccessRateController
{
    @javafx.fxml.FXML
    private TableColumn successRateTC;
    @javafx.fxml.FXML
    private TextField activityIdTextField;
    @javafx.fxml.FXML
    private TableView outputTableView;
    @javafx.fxml.FXML
    private TextField additionalCommentTextField;
    @javafx.fxml.FXML
    private TableColumn safetyTC;
    @javafx.fxml.FXML
    private ComboBox comfortComboBox;
    @javafx.fxml.FXML
    private ComboBox enjoymentComboBox;
    @javafx.fxml.FXML
    private TableColumn activityIdTC;
    @javafx.fxml.FXML
    private TableColumn comfortTC;
    @javafx.fxml.FXML
    private TableColumn additionalCommentTC;
    @javafx.fxml.FXML
    private ComboBox safetyCombobox;
    @javafx.fxml.FXML
    private TableColumn enjoymentTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("arman/ACDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void giveFeedBackButtonOnAction(ActionEvent actionEvent) {
    }
}