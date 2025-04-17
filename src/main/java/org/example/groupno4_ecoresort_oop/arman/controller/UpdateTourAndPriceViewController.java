package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;

public class UpdateTourAndPriceViewController
{
    @javafx.fxml.FXML
    private TableColumn guestNameTC;
    @javafx.fxml.FXML
    private TableColumn priceTC;
    @javafx.fxml.FXML
    private TableColumn seatReserveTC;
    @javafx.fxml.FXML
    private TextField updateGuestIdTextField;
    @javafx.fxml.FXML
    private TableView outputTableView;
    @javafx.fxml.FXML
    private TableColumn guestTypeTC;
    @javafx.fxml.FXML
    private Label outputDisplayLabel;
    @javafx.fxml.FXML
    private TableColumn guestIdTC;
    @javafx.fxml.FXML
    private TableColumn dateTC;
    @javafx.fxml.FXML
    private TextField UpdatedDescriptionTextField;
    @javafx.fxml.FXML
    private TextField updateGuestNameTextField;
    @javafx.fxml.FXML
    private TextField updatedPrceTextField;
    @javafx.fxml.FXML
    private TableColumn eventTypeTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
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