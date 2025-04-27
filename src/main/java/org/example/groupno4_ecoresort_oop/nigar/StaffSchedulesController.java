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
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;

import java.io.IOException;

public class StaffSchedulesController {

    @FXML
    private Button refreshButton;

    @FXML
    private TableView<StaffSchedule> staffTable;

    @FXML
    private TableColumn<StaffSchedule, String> staffIdColumn;

    @FXML
    private TableColumn<StaffSchedule, String> roomColumn;

    @FXML
    private TableColumn<StaffSchedule, String> shiftColumn;

    @FXML
    private TableColumn<StaffSchedule, String> timeColumn;

    private ObservableList<StaffSchedule> staffList = FXCollections.observableArrayList();

    Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    void initialize() {

        staffIdColumn.setCellValueFactory(cellData -> cellData.getValue().staffIdProperty());
        roomColumn.setCellValueFactory(cellData -> cellData.getValue().roomProperty());
        shiftColumn.setCellValueFactory(cellData -> cellData.getValue().shiftProperty());
        timeColumn.setCellValueFactory(cellData -> cellData.getValue().timeProperty());



    }


    private void StaffData() {

        staffList.add(new StaffSchedule("S001", "Room 101", "Morning", "8:00 AM - 4:00 PM"));
        staffList.add(new StaffSchedule("S002", "Room 102", "Afternoon", "4:00 PM - 12:00 AM"));
        staffList.add(new StaffSchedule("S003", "Room 103", "Night", "12:00 AM - 8:00 AM"));

        staffTable.setItems(staffList);
    }


    @FXML
    private void refreshTable(ActionEvent event) {

        staffList.clear();
        StaffData();
    }


    @FXML
    public void switchScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            Scene scene = new Scene(root, 1280, 720);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void switchToDashboard(ActionEvent event) {
        switchScene("nigar.controller/DashBoardController.fxml");
    }
}
