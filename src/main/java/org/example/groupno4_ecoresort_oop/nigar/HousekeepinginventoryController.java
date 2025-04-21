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

public class HousekeepinginventoryController {

    private final Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    private Button report;

    @FXML
    private TableView<InventoryItem> tableView;

    @FXML
    private TableColumn<InventoryItem, String> name;

    @FXML
    private TableColumn<InventoryItem, String> stock;

    @FXML
    private TableColumn<InventoryItem, String> status;

    @FXML
    private TableColumn<InventoryItem, String> request;


    @FXML
    public void initialize() {

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        request.setCellValueFactory(new PropertyValueFactory<>("request"));

        ObservableList<InventoryItem> items = FXCollections.observableArrayList(
                new InventoryItem("Towels", "15", "In Stock", "None"),
                new InventoryItem("Soap", "5", "Low", "Request"),
                new InventoryItem("Toilet Paper", "25", "In Stock", "None")
        );

        tableView.setItems(items);
    }

    @FXML
    private void switch1(ActionEvent event) {
        switchScene("nigar.controller/DashBoardController.fxml");
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
}
