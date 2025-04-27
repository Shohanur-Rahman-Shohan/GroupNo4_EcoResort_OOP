package org.example.groupno4_ecoresort_oop.Sadman;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ModifyReservationController {

    @FXML private TextField reservationIdField;
    @FXML private DatePicker newCheckInDatePicker;
    @FXML private DatePicker newCheckOutDatePicker;
    @FXML private TextField newRoomNumberField;
    @FXML private Button confirmButton;
    @FXML private Button backButton;

    @FXML private TableView<Reservation> reservationTable;
    @FXML private TableColumn<Reservation, String> roomNumberCol;
    @FXML private TableColumn<Reservation, String> nameCol;
    @FXML private TableColumn<Reservation, String> phoneCol;
    @FXML private TableColumn<Reservation, LocalDate> checkInCol;
    @FXML private TableColumn<Reservation, LocalDate> checkOutCol;
    @FXML private TableColumn<Reservation, Double> priceCol;

    private ObservableList<Reservation> reservationsData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        newCheckInDatePicker.setValue(LocalDate.now());
        newCheckOutDatePicker.setValue(LocalDate.now().plusDays(1));

        // Initialize table columns
        roomNumberCol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        checkInCol.setCellValueFactory(new PropertyValueFactory<>("checkInDate"));
        checkOutCol.setCellValueFactory(new PropertyValueFactory<>("checkOutDate"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        loadSampleReservations();
    }

    private void loadSampleReservations() {
        reservationsData.addAll(
                new Reservation("RES-123", "Sadman", "Sadman@example.com", "555-1234",
                        "101", LocalDate.now().plusDays(1), LocalDate.now().plusDays(3), 200),
                new Reservation("RES-456", "Lionel Messi", "messi@example.com", "555-5678",
                        "201", LocalDate.now().plusDays(2), LocalDate.now().plusDays(5), 450)

        );
        reservationTable.setItems(reservationsData);
    }

    @FXML
    private void handleConfirm() {
        String reservationId = reservationIdField.getText();
        LocalDate newCheckIn = newCheckInDatePicker.getValue();
        LocalDate newCheckOut = newCheckOutDatePicker.getValue();
        String newRoomNumber = newRoomNumberField.getText();

        if (reservationId.isEmpty()) {
            showAlert("Error", "Please enter a reservation ID");
            return;
        }

        for (Reservation reservation : reservationsData) {
            if (reservation.getReservationId().equals(reservationId)) {
                if (newCheckIn != null) reservation.setCheckInDate(newCheckIn);
                if (newCheckOut != null) reservation.setCheckOutDate(newCheckOut);
                if (!newRoomNumber.isEmpty()) reservation.setRoomNumber(newRoomNumber);

                long nights = reservation.getCheckInDate().until(reservation.getCheckOutDate()).getDays();
                reservation.setTotalPrice(nights * 100);

                reservationTable.refresh();
                showAlert("Success", "Reservation updated successfully");
                return;
            }
        }

        showAlert("Error", "Reservation not found");
    }

    @FXML
    private void handleBack() throws Exception {
        loadScene("Guest/GD.fxml");
    }

    private void loadScene(String fxmlFile) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource( fxmlFile));
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
