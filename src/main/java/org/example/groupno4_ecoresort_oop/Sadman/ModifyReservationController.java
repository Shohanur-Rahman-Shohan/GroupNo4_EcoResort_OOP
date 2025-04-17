package org.example.groupno4_ecoresort_oop.Sadman;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ModifyReservationController
{
    @javafx.fxml.FXML
    private TableColumn checkoutTableColumn;
    @javafx.fxml.FXML
    private TextField newRoomIDTextField;
    @javafx.fxml.FXML
    private TableColumn nameTableColumn;
    @javafx.fxml.FXML
    private TextField reservationIDTextField;
    @javafx.fxml.FXML
    private TableColumn checkInTableColumn;
    @javafx.fxml.FXML
    private TableColumn roomNoTableColumn;
    @javafx.fxml.FXML
    private DatePicker modCheckOutDatePicker;
    @javafx.fxml.FXML
    private TableColumn phoneTableColumn;
    @javafx.fxml.FXML
    private AnchorPane modCheckInDatePicker;
    @javafx.fxml.FXML
    private TableColumn chargesTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ConfirmOnAction(ActionEvent actionEvent) {
    }
}