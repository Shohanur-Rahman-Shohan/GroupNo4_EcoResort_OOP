package org.example.groupno4_ecoresort_oop.shohan.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.shohan.Event;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddEventController {

    @javafx.fxml.FXML
    private ComboBox<String> selectEvent_CB;
    @javafx.fxml.FXML
    private DatePicker eventDate_DP;
    @javafx.fxml.FXML
    private TextField noOfSeat_TF;
    @javafx.fxml.FXML
    private TextField eventCost_TF;
    @javafx.fxml.FXML
    private ComboBox<String> guestCatagory_CB;
    @javafx.fxml.FXML
    private Label message_L;
    @javafx.fxml.FXML
    private TableView<Event> table_T;
    @javafx.fxml.FXML
    private TableColumn<Event, Integer> eventCost_TC;
    @javafx.fxml.FXML
    private TableColumn<Event, String> eventName_TC;
    @javafx.fxml.FXML
    private TableColumn<Event, String> guestCatagory_TC;
    @javafx.fxml.FXML
    private TableColumn<Event, LocalDate> eventDate_TC;
    @javafx.fxml.FXML
    private TableColumn<Event, Integer> totalSeat_TC;

    File file = new File("Data/shohan/events.bin");
    ArrayList<Event> eventLST = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        selectEvent_CB.getItems().setAll("Hiking", "Swimming", "RockClimbing","Yoga","Bonfire Night");
        guestCatagory_CB.getItems().setAll("VIP", "General");

        eventName_TC.setCellValueFactory(new PropertyValueFactory<>("event"));
        totalSeat_TC.setCellValueFactory(new PropertyValueFactory<>("noOfSeat"));
        eventCost_TC.setCellValueFactory(new PropertyValueFactory<>("eventCost"));
        eventDate_TC.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
        guestCatagory_TC.setCellValueFactory(new PropertyValueFactory<>("guestCatagory"));


        if (!file.exists()) {
            List<Event> dummyEvents = new ArrayList<>();
            BinaryFileHelper.writeAllObjects(file, dummyEvents);
        }

        List<Event> readList = BinaryFileHelper.readAllObjects(file);
        eventLST.clear();
        eventLST.addAll(readList);
        table_T.getItems().setAll(eventLST);
    }

    @javafx.fxml.FXML
    public void addEvent_OA(ActionEvent actionEvent) {
        if (selectEvent_CB.getValue() == null || noOfSeat_TF.getText().isEmpty() || eventCost_TF.getText().isEmpty()
                || eventDate_DP.getValue() == null || guestCatagory_CB.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all fields properly.");
            alert.showAndWait();
            return;
        }

        String event = selectEvent_CB.getValue();
        int noOfSeat = Integer.parseInt(noOfSeat_TF.getText());
        int eventCost = Integer.parseInt(eventCost_TF.getText());
        LocalDate eventDate = eventDate_DP.getValue();
        String guestCatagory = guestCatagory_CB.getValue();

        Event newEvent = new Event(event, noOfSeat, eventCost, eventDate, guestCatagory);

        List<Event> existing = BinaryFileHelper.readAllObjects(file);
        existing.add(newEvent);
        BinaryFileHelper.writeAllObjects(file, existing);

        eventLST.clear();
        eventLST.addAll(existing);
        table_T.getItems().setAll(eventLST);
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("user/DashBoard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
