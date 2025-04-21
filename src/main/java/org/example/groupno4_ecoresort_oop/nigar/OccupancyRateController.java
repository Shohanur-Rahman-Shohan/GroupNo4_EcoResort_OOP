package org.example.groupno4_ecoresort_oop.nigar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;

import java.io.IOException;

public class OccupancyRateController {

    @FXML
    private TextField roomTypeField;

    @FXML
    private TextField dateField;

    @FXML
    private TableView<RoomOccupancy> tableView;

    @FXML
    private TableColumn<RoomOccupancy, String> roomTypeColumn;

    @FXML
    private TableColumn<RoomOccupancy, String> dateColumn;

    @FXML
    private TableColumn<RoomOccupancy, Integer> occupancyColumn;

    @FXML
    private Button track;

    private final ObservableList<RoomOccupancy> roomData = FXCollections.observableArrayList();
    private final Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    void initialize() {

        roomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        occupancyColumn.setCellValueFactory(cellData -> cellData.getValue().occupancyRateProperty().asObject());


        tableView.setItems(roomData);
    }

    @FXML
    public void switchScene(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1280, 720);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void switch1(ActionEvent event) {
        switchScene("/org/example/groupno4_ecoresort_oop/nigar/DashBoard.fxml");
    }

    @FXML
    private void onTrackClicked(ActionEvent event) {
        String roomType = roomTypeField.getText().trim();
        String date = dateField.getText().trim();

        if (validateInput(roomType, date)) {
            int dummyOccupancy = (int) (Math.random() * 100);
            roomData.add(new RoomOccupancy(roomType, date, dummyOccupancy));

            roomTypeField.clear();
            dateField.clear();
        }
    }

    private boolean validateInput(String roomType, String date) {
        if (roomType.isEmpty() || date.isEmpty()) {

            return false;
        }
        return true;
    }
}
