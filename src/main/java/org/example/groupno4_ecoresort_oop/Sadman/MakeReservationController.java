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
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MakeReservationController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField roomNumberField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private DatePicker checkInDatePicker;
    @FXML
    private DatePicker checkOutDatePicker;

    @FXML
    private TableView<Reservation> reservationTable;
    @FXML
    private TableColumn<Reservation, Double> reservationIdCol;
    @FXML
    private TableColumn<Reservation, String> nameCol;
    @FXML
    private TableColumn<Reservation, String> phoneCol;
    @FXML
    private TableColumn<Reservation, LocalDate> checkInCol;
    @FXML
    private TableColumn<Reservation, LocalDate> checkOutCol;
    @FXML
    private TableColumn<Reservation, Double> priceCol;

    private ObservableList<Reservation> reservationsData = FXCollections.observableArrayList();
    private AtomicInteger reservationCounter = new AtomicInteger(1000);// Starting reservation number
    @FXML
    private Button backButton;

    @FXML
    private void initialize() {
        checkInDatePicker.setValue(LocalDate.now());
        checkOutDatePicker.setValue(LocalDate.now().plusDays(1));

        reservationIdCol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        checkInCol.setCellValueFactory(new PropertyValueFactory<>("checkInDate"));
        checkOutCol.setCellValueFactory(new PropertyValueFactory<>("checkOutDate"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        reservationTable.setItems(reservationsData);

        generateNewReservationId();

    }

    private void generateNewReservationId() {
        Random random = new Random();
        int reservationId = random.nextInt(10000);
        reservationIdCol.setText("RES-" + reservationId);
    }

    @FXML
    private void handleConfirm() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String roomNumber = reservationIdCol.getText();
        LocalDate checkIn = checkInDatePicker.getValue();
        LocalDate checkOut = checkOutDatePicker.getValue();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || roomNumber.isEmpty()) {
            showAlert("Error", "All fields are required");
            return;
        }

        long nights = checkIn.until(checkOut).getDays();
        double totalPrice = nights * 100;

        Reservation newReservation = new Reservation(
                "RES-" + System.currentTimeMillis(),
                name,
                email,
                phone,
                roomNumber,
                checkIn,
                checkOut,
                totalPrice
        );

        reservationsData.add(newReservation);

        nameField.clear();
        emailField.clear();
        phoneField.clear();
        roomNumberField.clear();

        showAlert("Success", "Reservation created successfully");
    }

    @FXML
    private void handleBack() throws Exception {
        loadScene("Guest/GD.fxml");
    }

    private void loadScene(String fxmlFile) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
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



    public AtomicInteger getReservationCounter() {
        return reservationCounter;
    }

    public void setReservationCounter(AtomicInteger reservationCounter) {
        this.reservationCounter = reservationCounter;
    }
}