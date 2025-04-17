package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.TourSchedule;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TourScheduleViewController
{

    @javafx.fxml.FXML
    private TableColumn<TourSchedule, String> guestNameTC;
    @javafx.fxml.FXML
    private TableColumn<TourSchedule, Double> priceTC;
    @javafx.fxml.FXML
    private TableColumn<TourSchedule, Integer> seatReserveTC;
    @javafx.fxml.FXML
    private TableView<TourSchedule> outputTableView;
    @javafx.fxml.FXML
    private TableColumn<TourSchedule, String> guestTypeTC;
    @javafx.fxml.FXML
    private ComboBox<String> modifyEventTypeCombobox;
    @javafx.fxml.FXML
    private TextField modifyseatsToReserveTextField;
    @javafx.fxml.FXML
    private TableColumn<TourSchedule, String> guestIdTC;
    @javafx.fxml.FXML
    private ComboBox<String> eventTypeCombobox;
    @javafx.fxml.FXML
    private TableColumn<TourSchedule, LocalDate> dateTC;
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
    private ComboBox<String> guestTypeCombobox;
    @javafx.fxml.FXML
    private TextField modifypriceTextField;
    @javafx.fxml.FXML
    private TableColumn<TourSchedule,String> eventTypeTC;
    @javafx.fxml.FXML
    private TextField guestIDTextField1;

    @javafx.fxml.FXML
    public void initialize() {
        eventTypeCombobox.getItems().addAll("Adventure Activities","Village Tour","Tree-Plantingaa","Cultural Performance","Meditation Session");
        guestTypeCombobox.getItems().addAll("Individual","Couple", "Family","AdventureSeekers","ResearchGuests","Corporate","Eco-Conscious Guests");
        modifyEventTypeCombobox.getItems().addAll("Adventure Activities","Village Tour","Tree-Plantingaa","Cultural Performance","Meditation Session");

        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        guestIdTC.setCellValueFactory(new PropertyValueFactory<>("guestId"));
        guestNameTC.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
        seatReserveTC.setCellValueFactory(new PropertyValueFactory<>("seatReserver"));
        guestTypeTC.setCellValueFactory(new PropertyValueFactory<>("guestType"));
        eventTypeTC.setCellValueFactory(new PropertyValueFactory<>("eventtype"));


        File file = new File("Data/arman/tourschedule.bin");
        List<TourSchedule> tourSchedules = BinaryFileHelper.readAllObjects(file);
        outputTableView.getItems().addAll(tourSchedules);

    }


    @javafx.fxml.FXML
    public void modifyButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addButtonOnAction(ActionEvent actionEvent) {
//        String guestId, String guestName, LocalDate date, String eventtype, String guestType, int seatReserver, double price
        TourSchedule ts = new TourSchedule(guestIDTextField1.getText(),guestNameTextField.getText(),dateDatePickerTextField.getValue(),eventTypeCombobox.getValue(),guestTypeCombobox.getValue(),Integer.parseInt(seatsToReserveTextField.getText()),Double.parseDouble(priceTextField.getText()));
        File file = new File("Data/arman/tourschedule.bin");
        BinaryFileHelper.saveObject(file, ts);
        outputTableView.getItems().add(ts);

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