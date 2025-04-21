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

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BookingListController {

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
    private Button updatebookinglist;

    private final Stage stage = HelloApplication.getPrimaryStage();
    private static final String FILENAME = "bookings.bin";
    private static List<Booking> bookingList = new ArrayList<>();

    @FXML
    public void initialize() {
        colGuestName.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        colBookingId.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        colCheckInOut.setCellValueFactory(new PropertyValueFactory<>("checkInOut"));


        ObservableList<Booking> bookings = FXCollections.observableArrayList(bookingList);
        tableView.setItems(bookings);
    }

    private void loadBookingsFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            bookingList = (List<Booking>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            initializeDefaultBookings();
        }
    }

    private void initializeDefaultBookings() {
        bookingList.add(new Booking("Nigar", "106", "BKG006", "2025-04-20 to 2025-04-22"));
        bookingList.add(new Booking("Diba", "203", "BKG002", "2025-04-19 to 2025-04-21"));
    }

    @FXML
    private void switch1(ActionEvent event) {
        switchScene("/org/example/groupno4_ecoresort_oop/nigar/DashBoardController.fxml");
    }

    private void switchScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1280, 720);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setNotification(ActionEvent event) {
        System.out.println("notification");
    }

    @FXML
    private void switchSceneA(ActionEvent event) {
        switchScene("dashboard.fxml");
    }
}


