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

public class AnalyzingSalesDataController {

    @FXML
    private TableView<Report> tableView;

    @FXML
    private TableColumn<Report, String> dateColumn;

    @FXML
    private TableColumn<Report, Double> revenueColumn;

    @FXML
    private TableColumn<Report, Integer> salesColumn;

    @FXML
    private Button report;

    private Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    public void initialize() {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        revenueColumn.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        salesColumn.setCellValueFactory(new PropertyValueFactory<>("sales"));

        ObservableList<Report> data = FXCollections.observableArrayList(
                new Report("2023-01-01", 1000.0, 10),
                new Report("2023-01-02", 1500.5, 15),
                new Report("2023-01-03", 1200.75, 12)
        );

        tableView.setItems(data);
    }

    @FXML
    private void switch1(ActionEvent event) {
        switchScene("/org/example/groupno4_ecoresort_oop/nigar/DashBoardController.fxml");
    }

    private void switchScene(String fxmlPath) {
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
    private void switchToDashboard(ActionEvent event) {
        switchScene("/org/example/groupno4_ecoresort_oop/nigar/DashBoardController.fxml");
    }

    @FXML
    private void setNotification(ActionEvent event) {
        System.out.println("report");
    }
}








