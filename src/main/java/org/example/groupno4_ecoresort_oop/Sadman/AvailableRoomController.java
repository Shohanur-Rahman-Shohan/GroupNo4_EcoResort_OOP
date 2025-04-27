package org.example.groupno4_ecoresort_oop.Sadman;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AvailableRoomController {

    @FXML private DatePicker checkInDatePicker;
    @FXML private DatePicker checkOutDatePicker;
    @FXML private ComboBox<String> bedTypeCombo;
    @FXML private ComboBox<String> viewTypeCombo;
    @FXML private ComboBox<String> roomTypeCombo;
    @FXML private Button searchButton;
    @FXML private Button backButton;

    @FXML private TableView<Room> roomsTable;
    @FXML private TableColumn<Room, String> roomNumberCol;
    @FXML private TableColumn<Room, String> roomTypeCol;
    @FXML private TableColumn<Room, String> bedTypeCol;
    @FXML private TableColumn<Room, String> viewTypeCol;
    @FXML private TableColumn<Room, Double> priceCol;

    private ObservableList<Room> roomsData = FXCollections.observableArrayList();
    @FXML
    private Button makeReservationButton;
    @FXML
    private Button filt;
    @FXML
    private DatePicker FilterCheckInDatePicker;
    @FXML
    private ComboBox<String> FilterRmCB;
    @FXML
    private DatePicker FiltercheckOutDatepicker;

    @FXML
    private void initialize() {
        bedTypeCombo.getItems().addAll("Single", "Double", "King");
        viewTypeCombo.getItems().addAll("City View", "Garden View", "Sea View");
        roomTypeCombo.getItems().addAll("Standard", "Deluxe", "Suite");

        checkInDatePicker.setValue(LocalDate.now());
        checkOutDatePicker.setValue(LocalDate.now().plusDays(1));

        roomNumberCol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        bedTypeCol.setCellValueFactory(new PropertyValueFactory<>("bedType"));
        viewTypeCol.setCellValueFactory(new PropertyValueFactory<>("viewType"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("pricePerNight"));

        loadSampleRooms();
    }

    private void loadSampleRooms() {
        roomsData.addAll(
                new Room("101", "Standard", "Single", "City View", 100),
                new Room("102", "Standard", "Double", "City View", 120),
                new Room("201", "Deluxe", "Double", "Garden View", 150),
                new Room("202", "Deluxe", "King", "Garden View", 180),
                new Room("301", "Suite", "King", "Sea View", 250)
        );
        roomsTable.setItems(roomsData);
    }

    @FXML
    private void handleSearch() {
        String bedType = bedTypeCombo.getValue();
        String viewType = viewTypeCombo.getValue();
        String roomType = roomTypeCombo.getValue();

        ObservableList<Room> filteredRooms = FXCollections.observableArrayList();

        for (Room room : roomsData) {
            boolean matches = true;

            if (bedType != null && !bedType.equals(room.getBedType())) matches = false;
            if (viewType != null && !viewType.equals(room.getViewType())) matches = false;
            if (roomType != null && !roomType.equals(room.getRoomType())) matches = false;

            if (matches) filteredRooms.add(room);
        }

        roomsTable.setItems(filteredRooms);
    }

    @FXML
    private void handleClear() {
        bedTypeCombo.setValue(null);
        viewTypeCombo.setValue(null);
        roomTypeCombo.setValue(null);
        roomsTable.setItems(roomsData);
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

    @FXML
    public void handleMakeReservation(ActionEvent actionEvent) {
        try {
            loadScene("Guest/MakeReservationView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}