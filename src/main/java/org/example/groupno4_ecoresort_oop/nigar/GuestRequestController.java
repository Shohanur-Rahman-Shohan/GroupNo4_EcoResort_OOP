package org.example.groupno4_ecoresort_oop.nigar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class GuestRequestController {

    @FXML
    private TableView<RequestItem> tableView;

    @FXML
    private TableColumn<RequestItem, String> dateColumn;

    @FXML
    private TableColumn<RequestItem, String> priorityColumn;

    @FXML
    private TableColumn<RequestItem, String> requestColumn;

    @FXML
    private Button submitrequest;

    @FXML
    private Button clear;

    private final Stage stage = DashboardController.getPrimaryStage();

    @FXML
    public void initialize() {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        requestColumn.setCellValueFactory(new PropertyValueFactory<>("request"));

        List<RequestItem> requests = loadRequestsFromTextFile("guest_requests.txt");
        ObservableList<RequestItem> data = FXCollections.observableArrayList(requests);
        tableView.setItems(data);
    }

    private List<RequestItem> loadRequestsFromTextFile(String filename) {
        List<RequestItem> requestList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\|");
                if (parts.length == 3) {
                    String date = parts[0];
                    String priority = parts[1];
                    String request = parts[2];

                    requestList.add(new RequestItem(date, priority, request));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return requestList;
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
    private void handleSubmitRequest(javafx.event.ActionEvent event) {
        System.out.println("Submit request");
    }

    @FXML
    private void handleClear(javafx.event.ActionEvent event) {
        tableView.getItems().clear();
        System.out.println("Table");
    }

    @FXML
    private void switchSceneA(String event) {
        switchSceneA("dashboard.fxml");
    }
}


