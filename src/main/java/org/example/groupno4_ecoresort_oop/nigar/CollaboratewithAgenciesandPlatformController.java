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

public class CollaboratewithAgenciesandPlatformController {

    private final Stage stage = HelloApplication.getPrimaryStage();


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
    private TableView<Agency> agencyTable;

    @FXML
    private TableColumn<Agency, String> colAgencyName;

    @FXML
    private TableColumn<Agency, String> colContact;

    @FXML
    private TableColumn<Agency, String> colPromotion;

    @FXML
    private Button addpromotion;


    @FXML
    public void initialize() {
        colAgencyName.setCellValueFactory(new PropertyValueFactory<>("agencyName"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colPromotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));

        ObservableList<Agency> agencies = FXCollections.observableArrayList(
                new Agency("EcoTours", "contact@ecotours.com", "10% off package tours"),
                new Agency("GreenWay Travel", "info@greenway.com", "Free eco-certification listing")
        );

        agencyTable.setItems(agencies);
    }


    @FXML
    private void addPromotion(ActionEvent event) {
        System.out.println("Add promotion logic goes here.");
    }
}



