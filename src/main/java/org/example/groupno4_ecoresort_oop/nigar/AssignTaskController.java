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

public class AssignTaskController {

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
    private Button notificationButton;

    private Stage stage = DashboardController.getPrimaryStage();

    @FXML
    public void initialize() {
        colStaffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        colTask.setCellValueFactory(new PropertyValueFactory<>("task"));
        colRoomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        List<Task> taskList = loadTasksFromTextFile("task_data.txt");
        ObservableList<Task> data = FXCollections.observableArrayList(taskList);
        taskTable.setItems(data);
    }

    private List<Task> loadTasksFromTextFile(String filename) {
        List<Task> tasks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 5) {
                    String staffId = parts[0];
                    String task = parts[1].replace('_', ' ');
                    String roomNumber = parts[2];
                    String time = parts[3];
                    String date = parts[4];

                    tasks.add(new Task(staffId, task, roomNumber, time, date));
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
        System.out.println("notification");
    }

    @FXML
    private void switchSceneA(ActionEvent event) {
        switchScene("dashboard.fxml");
    }
}











