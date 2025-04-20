package org.example.groupno4_ecoresort_oop.shohan.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;

public class RoomOccupancyController
{
    @javafx.fxml.FXML
    private TableColumn guestName_TC;
    @javafx.fxml.FXML
    private TableView roomOccupancy_TV;
    @javafx.fxml.FXML
    private TableColumn guestID_TC;
    @javafx.fxml.FXML
    private TableColumn stayDuration_TC;
    @javafx.fxml.FXML
    private TableColumn serialNo_TC;
    @javafx.fxml.FXML
    private ComboBox<String> filterAs_CB;
    @javafx.fxml.FXML
    private TableColumn roomStatus_TC;
    @javafx.fxml.FXML
    private TableColumn guestCatagory_TC;
    @javafx.fxml.FXML
    private TableColumn reservationDate_TC;
    @javafx.fxml.FXML
    private Label message_L;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("user/DashBoard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void resetFilter_OA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void filter_OA(ActionEvent actionEvent) {
    }
}