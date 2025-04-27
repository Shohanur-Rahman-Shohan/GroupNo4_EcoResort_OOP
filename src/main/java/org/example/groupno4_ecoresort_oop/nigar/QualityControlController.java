package org.example.groupno4_ecoresort_oop.nigar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;

import java.io.IOException;

public class QualityControlController {

    @FXML
    private TableView<RoomStatus> tableView;

    @FXML
    private TableColumn<RoomStatus, String> roomNoColumn;

    @FXML
    private TableColumn<RoomStatus, String> timeScheduleColumn;

    @FXML
    private TableColumn<RoomStatus, String> progressColumn;

    @FXML
    private TableColumn<RoomStatus, String> maintenanceColumn;

    @FXML
    private TableColumn<RoomStatus, String> feedbackColumn;

    @FXML
    private TableColumn<RoomStatus, String> notificationColumn;

    private final ObservableList<RoomStatus> data = FXCollections.observableArrayList();

    private final Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    public void initialize() {

        roomNoColumn.setCellValueFactory(cellData -> cellData.getValue().roomNoProperty());
        timeScheduleColumn.setCellValueFactory(cellData -> cellData.getValue().timeScheduleProperty());
        progressColumn.setCellValueFactory(cellData -> cellData.getValue().progressProperty());
        maintenanceColumn.setCellValueFactory(cellData -> cellData.getValue().maintenanceProperty());
        feedbackColumn.setCellValueFactory(cellData -> cellData.getValue().feedbackProperty());
        notificationColumn.setCellValueFactory(cellData -> cellData.getValue().notificationProperty());

        tableView.setItems(data);


    }

    @FXML
    private void switch1(ActionEvent event) {
        switchScene("/org/example/groupno4_ecoresort_oop/nigar/DashBoard.fxml");
    }

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

    private void Data() {
        data.add(new RoomStatus("101", "10:00 AM", "In Progress", "No Issues", "Clean and tidy", "None"));
        data.add(new RoomStatus("102", "11:00 AM", "Completed", "Leaky tap", "Resolved quickly", "Maintenance notified"));
        data.add(new RoomStatus("103", "12:00 PM", "Pending", "Broken AC", "Awaiting response", "Urgent"));
    }
}
