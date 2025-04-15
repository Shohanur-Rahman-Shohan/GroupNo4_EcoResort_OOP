package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.arman.EcoTour;
import org.example.groupno4_ecoresort_oop.arman.TourSchedule;

import java.time.LocalDate;
import java.util.ArrayList;

public class TourScheduleViewController
{
    @javafx.fxml.FXML
    private TableColumn EventTypeTableColumn;
    @javafx.fxml.FXML
    private TableView outputTableView;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<EcoTour,String> guestTypeTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> modifyEventTypeCombobox;
    @javafx.fxml.FXML
    private TableColumn<EcoTour,Integer> setReserveTableColumn;
    @javafx.fxml.FXML
    private TableColumn<EcoTour,String> guestIdTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> eventTypeCombobox;
    @javafx.fxml.FXML
    private TextField modifyGuestIdTextField;
    @javafx.fxml.FXML
    private DatePicker modifyDateDatePicker;
    @javafx.fxml.FXML
    private TextField guestNameTextField;
    @javafx.fxml.FXML
    private TextField modifySeatsToReserveTextField;
    @javafx.fxml.FXML
    private TableColumn<EcoTour,Double> priceTableColumn;
    @javafx.fxml.FXML
    private TextField modifyPriceTextField;
    @javafx.fxml.FXML
    private TextField seatToReserveTextField;
    @javafx.fxml.FXML
    private TableColumn<EcoTour, LocalDate> DateTableColumn;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private TextField guestIDTextField;
    @javafx.fxml.FXML
    private ComboBox<String> guestTypeCombobox;
    @javafx.fxml.FXML
    private TableColumn<EcoTour,String> guestNameTableColumn;

    @javafx.fxml.FXML

    public void initialize() {
      eventTypeCombobox.getItems().addAll("Adventure Activities", "Village Tour", "Tree-Planting", "Cultural Performance", "Meditation Session");
    guestTypeCombobox.getItems().addAll("Individual", "Couple", "Family", "Adventure Seekers", "Research Guests", "Corporate");
    modifyEventTypeCombobox.getItems().addAll("Adventure Activities", "Village Tour", "Tree-Planting", "Cultural Performance", "Meditation Session");

        guestIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("guestId"));
        guestNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        guestTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("guestType"));
        EventTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("eventType"));
        setReserveTableColumn.setCellValueFactory(new PropertyValueFactory<>("seatsReserved"));
        DateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
ArrayList<EcoTour> ecoTours=new ArrayList<>();



    @javafx.fxml.FXML
    public void addButtonOnAction(ActionEvent actionEvent) {
        try {
            String guestId = guestIDTextField.getText();
            String guestName = guestNameTextField.getText();
            String eventType = eventTypeCombobox.getValue();
            String guestType = guestTypeCombobox.getValue();
            int seats = Integer.parseInt(seatToReserveTextField.getText());
            double price = Double.parseDouble(priceTextField.getText());
            LocalDate date = dateDatePicker.getValue();

            if (guestId.isEmpty() || guestName.isEmpty() || eventType == null || guestType == null || date == null) {
                showAlert("Please fill all fields.");
                return;
            }

            if (seats <= 0) {
                showAlert("Seats must be a positive number.");
                return;
            }

            if (date.isBefore(LocalDate.now())) {
                showAlert("Date cannot be in the past.");
                return;
            }


            EcoTour tour = new EcoTour(guestId, guestName, eventType, guestType, seats, date, price);
            ecoTours.add(tour);
            clearInputFields();
            showAlert("Tour scheduled successfully!");

        } catch (NumberFormatException e) {
            showAlert("Seats and price must be numeric values.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearInputFields() {
        guestIDTextField.clear();
        guestNameTextField.clear();
        seatToReserveTextField.clear();
        priceTextField.clear();
        dateDatePicker.setValue(null);
        eventTypeCombobox.setValue(null);
        guestTypeCombobox.setValue(null);
    }

    @javafx.fxml.FXML
    public void modifyButtonOnAction(ActionEvent actionEvent) {
    }

    }
