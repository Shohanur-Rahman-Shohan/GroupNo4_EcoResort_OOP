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

public class AnalyzingSalesDataController {
    @FXML
    Button button;

    @FXML
    private TableView<Report> tableView;

    @FXML
    private TableColumn<Report, String> dateColumn;

    @FXML
    private TableColumn<Report, Double> revenueColumn;

    @FXML
    private TableColumn<Report, Integer> salesColumn;

    public class newcontroller {

    }

    private Stage stage = DashboardController.getPrimaryStage();

    @FXML
    public void initialize() {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        revenueColumn.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        salesColumn.setCellValueFactory(new PropertyValueFactory<>("sales"));

        List<Report> reportList = loadReportsFromTextFile("sales_report.txt");
        ObservableList<Report> data = FXCollections.observableArrayList(reportList);
        tableView.setItems(data);
    }

    private List<Report> loadReportsFromTextFile(String filename) {
        List<Report> reports = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 3) {
                    String date = parts[0];
                    double revenue = Double.parseDouble(parts[1]);
                    int sales = Integer.parseInt(parts[2]);

                    reports.add(new Report(date, revenue, sales));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reports;
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
        System.out.println("Report");
    }

    @FXML
    private void switchSceneA(ActionEvent event) {
        switchScene("dashboard.fxml");
    }
}




