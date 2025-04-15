package org.example.groupno4_ecoresort_oop.Sadman;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;


public class AvailableRooms
{
    @FXML
    private DatePicker checkInDatepicker;
    @FXML
    private ComboBox<String> VfCB;
    @FXML
    private DatePicker checkOutDatepicker;
    @FXML
    private ComboBox<String> BfCB;
    @FXML
    private ComboBox RmCB;

    @FXML
    public void initialize() {
        ObservableList<String> RmCB = FXCollections.observableArrayList("Single Room", "Double Room", "Suite");


    }


    @FXML
    public void BpCB(Event event) {
    }

    @FXML
    public void clearfilterOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void makeReservationOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void filterOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void SearchRoomOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void RmCBOnAction(ActionEvent actionEvent) {
    }
}