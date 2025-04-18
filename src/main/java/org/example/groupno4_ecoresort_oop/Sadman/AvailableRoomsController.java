package org.example.groupno4_ecoresort_oop.Sadman;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;


public class AvailableRoomsController
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
    private Label chInLabel;
    @FXML
    private TableColumn<String, String> roomTypeColumn;
    @FXML
    private TableColumn<String, String> BPColumn;
    @FXML
    private TableColumn<String, String> VPColumn;
    @FXML
    private TableColumn<Double,Double> RoomNoColumn;
    @FXML
    private Label chOutLabel;
    @FXML
    private TableColumn<Double,Double> PriceColumn;
    @FXML
    private TableView<AvailableRooms> TableView;
    @FXML
    private DatePicker FiltercheckInDatepicker;
    @FXML
    private Label chInLabel1;
    @FXML
    private ComboBox<String> FilterRmCB;
    @FXML
    private TableColumn<LocalDate,LocalDate> checkInColumn;
    @FXML
    private Label chOutLabel1;
    @FXML
    private DatePicker FiltercheckOutDatepicker;
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

        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        BPColumn.setCellValueFactory(new PropertyValueFactory<>("bedP"));
        VPColumn.setCellValueFactory(new PropertyValueFactory<>("ViewP"));
        RoomNoColumn.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        checkInColumn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));




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
        FilterRmCB.getItems().addAll("Single Room" , "Double Room", "Suite");
        FiltercheckInDatepicker.getValue();
        FiltercheckOutDatepicker.getValue();
    }

    @FXML
    public void SearchRoomOnAction(ActionEvent actionEvent) {
        LocalDate checkInDate = checkInDatepicker.getValue();
        LocalDate checkOutDate = checkOutDatepicker.getValue();
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