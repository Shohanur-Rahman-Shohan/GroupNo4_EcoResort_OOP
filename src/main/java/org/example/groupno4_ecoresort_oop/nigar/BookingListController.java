package org.example.groupno4_ecoresort_oop.nigar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;

import java.io.IOException;

public class BookingListController {

    private final Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    private Button createschedule;

    @FXML
    private Button updatebookinglist;

    @FXML
    private TableView<Booking> tableView;

    @FXML
    private TableColumn<Booking, String> colGuestName;

    @FXML
    private TableColumn<Booking, String> colRoomNo;

    @FXML
    private TableColumn<Booking, String> colBookingId;

    @FXML
    private TableColumn<Booking, String> colCheckInOut;

    @FXML
    public void initialize() {

        colGuestName.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        colBookingId.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        colCheckInOut.setCellValueFactory(new PropertyValueFactory<>("checkInOut"));

        ObservableList<Booking> bookings = FXCollections.observableArrayList(
                new Booking("Nigar", "106", "BKG006", "2025-04-20 to 2025-04-22"),
                new Booking("Diba", "203", "BKG002", "2025-04-19 to 2025-04-21")
        );

        tableView.setItems(bookings);
    }

    @FXML
    private void switch1(ActionEvent event) {
        switchScene("nigar.controller/DashBoardController.fxml");
    }

    public void switchScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1280, 720);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}



