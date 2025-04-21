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

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DailyReportsController {

    @FXML
    private Button generatereports;

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

    private Stage stage = DashboardController.getPrimaryStage();

    @FXML
    public void initialize() {
        colStaffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        colRoomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        colCompletedTask.setCellValueFactory(new PropertyValueFactory<>("completedTask"));
        colIncompleteTask.setCellValueFactory(new PropertyValueFactory<>("incompleteTask"));
        colTimeSchedule.setCellValueFactory(new PropertyValueFactory<>("timeSchedule"));
        colFeedback.setCellValueFactory(new PropertyValueFactory<>("feedback"));

        List<TaskStatus> taskList = loadDailyReportsFromTextFile("daily_reports.txt");
        ObservableList<TaskStatus> data = FXCollections.observableArrayList(taskList);
        taskTable.setItems(data);
    }

    private List<TaskStatus> loadDailyReportsFromTextFile(String filename) {
        List<TaskStatus> tasks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\|"); // Using '|' as a delimiter
                if (parts.length == 6) {
                    String staffId = parts[0];
                    String roomNumber = parts[1];
                    String completedTask = parts[2];
                    String incompleteTask = parts[3];
                    String timeSchedule = parts[4];
                    String feedback = parts[5];

                    tasks.add(new TaskStatus(staffId, roomNumber, completedTask, incompleteTask, timeSchedule, feedback));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }


    private void switchScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1280, 720);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setNotification(javafx.event.ActionEvent event) {
        System.out.println("generate reports");
    }

    @FXML
    private void switchSceneA(ActionEvent event) {
        switchScene("dashboard.fxml");
    }
}









