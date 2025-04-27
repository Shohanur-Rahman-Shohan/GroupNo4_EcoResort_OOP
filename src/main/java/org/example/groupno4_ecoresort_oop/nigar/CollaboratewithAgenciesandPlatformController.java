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

public class CollaboratewithAgenciesandPlatformController {

    @FXML
    private TableView<Agency> agencyTable;

    @FXML
    private TableColumn<Agency, String> colAgencyName;

    @FXML
    private TableColumn<Agency, String> colContact;

    @FXML
    private TableColumn<Agency, String> colPromotion;

    @FXML
    private Button addPromotion;

    private Stage stage = DashboardController.getPrimaryStage(); // or HelloApplication.getPrimaryStage()

    @FXML
    public void initialize() {
        colAgencyName.setCellValueFactory(new PropertyValueFactory<>("agencyName"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colPromotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));

        List<Agency> agencyList = loadAgenciesFromTextFile("agencies.txt");
        ObservableList<Agency> data = FXCollections.observableArrayList(agencyList);
        agencyTable.setItems(data);
    }

    private List<Agency> loadAgenciesFromTextFile(String filename) {
        List<Agency> agencies = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\|"); // Use | as delimiter
                if (parts.length == 3) {
                    String agencyName = parts[0];
                    String contact = parts[1];
                    String promotion = parts[2];

                    agencies.add(new Agency(agencyName, contact, promotion));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return agencies;
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
private void setNotification(ActionEvent event) {
    System.out.println("add promotion");
}

@FXML
private void switchSceneA(ActionEvent event) {
    switchScene("dashboard.fxml");
}
}


