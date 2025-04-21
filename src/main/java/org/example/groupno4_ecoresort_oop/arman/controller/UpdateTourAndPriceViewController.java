package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.TourSchedule;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class UpdateTourAndPriceViewController
{
    @javafx.fxml.FXML
    private TableColumn<TourSchedule, String> guestNameTC;
    @javafx.fxml.FXML
    private TableColumn<TourSchedule, Double> priceTC;
    @javafx.fxml.FXML
    private TableColumn<TourSchedule, Integer> seatReserveTC;
    @javafx.fxml.FXML
    private TextField updateGuestIdTextField;
    @javafx.fxml.FXML
    private TableView<TourSchedule> outputTableView;
    @javafx.fxml.FXML
    private TableColumn<TourSchedule, String> guestTypeTC;
    @javafx.fxml.FXML
    private Label outputDisplayLabel;
    @javafx.fxml.FXML
    private TableColumn<TourSchedule, String> guestIdTC;
    @javafx.fxml.FXML
    private TableColumn<TourSchedule, String> eventTypeTC;
    @javafx.fxml.FXML
    private TextField UpdatedDescriptionTextField;
    @javafx.fxml.FXML
    private TextField updateGuestNameTextField;
    @javafx.fxml.FXML
    private TextField updatedPrceTextField;
    @javafx.fxml.FXML
    private TableColumn<TourSchedule, String> dateTC;

    @javafx.fxml.FXML
    public void initialize() {

        guestIdTC.setCellValueFactory(new PropertyValueFactory<>("guestId"));
        guestNameTC.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        guestTypeTC.setCellValueFactory(new PropertyValueFactory<>("guestType"));
        seatReserveTC.setCellValueFactory(new PropertyValueFactory<>("seatReserver"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
        eventTypeTC.setCellValueFactory(new PropertyValueFactory<>("eventtype"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

        File file = new File("Data/arman/tourschedule.bin");
        List<TourSchedule> tourSchedules = BinaryFileHelper.readAllObjects(file);
        outputTableView.getItems().addAll(tourSchedules);
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
        String guestId = updateGuestIdTextField.getText();
        String newGuestName = updateGuestNameTextField.getText();
        double newPrice = 0;


        try {
            newPrice = Double.parseDouble(updatedPrceTextField.getText());
        } catch (NumberFormatException e) {
            outputDisplayLabel.setText("Invalid price format.");
            return;  // Exit the method if the price format is incorrect
        }


        File file = new File("Data/arman/tourschedule.bin");
        List<TourSchedule> tourSchedules = BinaryFileHelper.readAllObjects(file);

        boolean found = false;
        for (TourSchedule ts : tourSchedules) {
            if (ts.getGuestId().equals(guestId)) {
                ts.setGuestName(newGuestName);
                ts.setPrice(newPrice);
                found = true;
                break;
            }
        }

        if (found) {

            BinaryFileHelper.writeAllObjects(file, tourSchedules);

            outputTableView.getItems().clear();
            outputTableView.getItems().addAll(tourSchedules);

            outputDisplayLabel.setText("Tour Schedule Updated Successfully!");
        } else {

            outputDisplayLabel.setText("Guest ID not found.");
        }
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {

            SceneSwitcher.switchTo("arman/ACDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}