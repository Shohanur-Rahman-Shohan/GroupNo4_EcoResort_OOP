package org.example.groupno4_ecoresort_oop.Sadman;

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
    private ComboBox<String> RmCB;

    @FXML
    public void initialize() {
        RmCB.getItems().addAll("Single Room" , "Double Room", "Suite");
        BfCB.getItems().addAll("King Size bed" , "Family Bed", "Two single beds");
        VfCB.getItems().addAll("Sea View", "Garden View", "Pool View");

        VfCB.setValue("Sea View");
        RmCB.setValue("Single Room");
        BfCB.setValue("Family Bed");

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

    @FXML
    public void BfCBCombobox(ActionEvent actionEvent) {
    }

    @FXML
    public void VfCombobox(ActionEvent actionEvent) {
    }
}