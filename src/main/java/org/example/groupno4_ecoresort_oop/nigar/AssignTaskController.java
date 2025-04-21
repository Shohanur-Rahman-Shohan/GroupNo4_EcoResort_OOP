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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;


import java.io.IOException;

public class AssignTaskController {

    // Stage reference to switch scenes
    private final Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    private Button notificationButton;

    @FXML
    private TableView<Task> taskTable;

    @FXML
    private TableColumn<Task, String> colStaffId;

    @FXML
    private TableColumn<Task, String> colTask;

    @FXML
    private TableColumn<Task, String> colRoomNumber;

    @FXML
    private TableColumn<Task, String> colTime;

    @FXML
    private TableColumn<Task, String> colDate;


    @FXML
    public void initialize() {

        colStaffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        colTask.setCellValueFactory(new PropertyValueFactory<>("task"));
        colRoomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));


        ObservableList<Task> tasks = FXCollections.observableArrayList(
                new Task("S101", "Clean Room", "101", "10:00 AM", "2025-04-18"),
                new Task("S102", "Fix AC", "202", "11:00 AM", "2025-04-18")
        );


        taskTable.setItems(tasks);
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

    @FXML
    private void setNotification(ActionEvent event) {
        System.out.println("Notification");
    }
}











