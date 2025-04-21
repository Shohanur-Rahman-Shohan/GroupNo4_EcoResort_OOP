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

public class DailyReportsController {

    private final Stage stage = HelloApplication.getPrimaryStage();


    @FXML
    private Button generatereport;


    @FXML
    private TableView<TaskStatus> taskTable;

    @FXML
    private TableColumn<TaskStatus, String> colStaffId;

    @FXML
    private TableColumn<TaskStatus, String> colRoomNumber;

    @FXML
    private TableColumn<TaskStatus, String> colCompletedTask;

    @FXML
    private TableColumn<TaskStatus, String> colIncompleteTask;

    @FXML
    private TableColumn<TaskStatus, String> colTimeSchedule;

    @FXML
    private TableColumn<TaskStatus, String> colFeedback;


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
    private void switch1(ActionEvent event) {
        switchScene("nigar.controller/DashBoardController.fxml");
    }


    @FXML
    public void initialize() {

        colStaffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        colRoomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        colCompletedTask.setCellValueFactory(new PropertyValueFactory<>("completedTask"));
        colIncompleteTask.setCellValueFactory(new PropertyValueFactory<>("incompleteTask"));
        colTimeSchedule.setCellValueFactory(new PropertyValueFactory<>("timeSchedule"));
        colFeedback.setCellValueFactory(new PropertyValueFactory<>("feedback"));


        ObservableList<TaskStatus> reportData = FXCollections.observableArrayList(
                new TaskStatus("S001", "101", "Cleaned", "None", "08:00 - 09:00", "Excellent"),
                new TaskStatus("S002", "102", "Checked", "Restock pending", "09:00 - 10:00", "Needs improvement")
        );

        taskTable.setItems(reportData);
    }
}






