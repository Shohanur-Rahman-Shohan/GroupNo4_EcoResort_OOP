package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.TourSchedule;
import org.example.groupno4_ecoresort_oop.utils.FileHandler;

import java.util.ArrayList;

public class TourScheduleViewController
{

    @javafx.fxml.FXML
    private TableColumn guestNameTC;
    @javafx.fxml.FXML
    private TableColumn priceTC;
    @javafx.fxml.FXML
    private TableColumn seatReserveTC;
    @javafx.fxml.FXML
    private TableView outputTableView;
    @javafx.fxml.FXML
    private TableColumn guestTypeTC;
    @javafx.fxml.FXML
    private ComboBox modifyEventTypeCombobox;
    @javafx.fxml.FXML
    private TextField modifyseatsToReserveTextField;
    @javafx.fxml.FXML
    private TableColumn guestIdTC;
    @javafx.fxml.FXML
    private ComboBox eventTypeCombobox;
    @javafx.fxml.FXML
    private TableColumn dateTC;
    @javafx.fxml.FXML
    private TextField modifyGuestIdTextField;
    @javafx.fxml.FXML
    private TextField seatsToReserveTextField;
    @javafx.fxml.FXML
    private DatePicker modifyDateDatePicker;
    @javafx.fxml.FXML
    private TextField guestNameTextField;
    @javafx.fxml.FXML
    private DatePicker dateDatePickerTextField;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private ComboBox guestTypeCombobox;
    @javafx.fxml.FXML
    private TextField modifypriceTextField;
    @javafx.fxml.FXML
    private TableColumn eventTypeTC;
    @javafx.fxml.FXML
    private TextField guestIdTextField1;

    @javafx.fxml.FXML
    public void initialize() {
        eventTypeCombobox.getItems().addAll("Adventure Activities","Village Tour","Tree-Plantingaa","Cultural Performance","Meditation Session");
        guestTypeCombobox.getItems().addAll("Individual","Couple", "Family","AdventureSeekers","ResearchGuests","Corporate","Eco-Conscious Guests");
        modifyEventTypeCombobox.getItems().addAll("Adventure Activities","Village Tour","Tree-Plantingaa","Cultural Performance","Meditation Session");
    }


    @javafx.fxml.FXML
    public void modifyButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addButtonOnAction(ActionEvent actionEvent) {
        TourSchedule tourschedule = new TourSchedule();
        FileHandler.writeObjectToFile(tourschedule, "TourSchedule.txt");

    }

    @javafx.fxml.FXML
    public void BackButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("arman/ACDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}