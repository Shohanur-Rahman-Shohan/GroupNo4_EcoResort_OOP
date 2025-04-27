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

public class HousekeepingInventoryController {

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
    private Button report;

    private final Stage stage = DashboardController.getPrimaryStage();

    @FXML
    public void initialize() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        request.setCellValueFactory(new PropertyValueFactory<>("request"));

        List<InventoryItem> inventoryList = loadInventoryFromTextFile("inventory_data.txt");
        ObservableList<InventoryItem> data = FXCollections.observableArrayList(inventoryList);
        tableView.setItems(data);
    }

    private List<InventoryItem> loadInventoryFromTextFile(String filename) {
        List<InventoryItem> items = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s*\\|\\s*");
                if (parts.length == 4) {
                    String name = parts[0];
                    String stock = parts[1];
                    String status = parts[2];
                    String request = parts[3];

                    items.add(new InventoryItem(name, stock, status, request));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
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
    private void setNotification(javafx.event.ActionEvent event) {
        System.out.println("Report");
    }

    @FXML
    public void switchSceneA(ActionEvent event) {
        switchScene("dash.fxml");
    }
}