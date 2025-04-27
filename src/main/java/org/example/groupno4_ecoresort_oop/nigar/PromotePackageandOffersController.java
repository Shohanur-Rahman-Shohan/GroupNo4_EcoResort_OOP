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
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;

import java.io.IOException;

public class PromotePackageandOffersController {

    @FXML
    private Button createpromotion;

    @FXML
    private TableView<OfferData> tableView;

    @FXML
    private TableColumn<OfferData, String> packageColumn;

    @FXML
    private TableColumn<OfferData, String> offerColumn;

    @FXML
    private TableColumn<OfferData, String> roomTypeColumn;

    @FXML
    private TableColumn<OfferData, String> discountColumn;

    private final ObservableList<OfferData> offerList = FXCollections.observableArrayList();

    Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    void initialize() {

        packageColumn.setCellValueFactory(cellData -> cellData.getValue().packageNameProperty());
        offerColumn.setCellValueFactory(cellData -> cellData.getValue().offerDetailProperty());
        roomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
        discountColumn.setCellValueFactory(cellData -> cellData.getValue().discountProperty());


        tableView.setItems(offerList);
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
    private void switch1(ActionEvent event) {
        switchScene("/org/example/groupno4_ecoresort_oop/nigar/DashBoard.fxml");
    }

    @FXML
    private void onCreatePromotionClicked(ActionEvent event) {

        offerList.add(new OfferData("Holiday Escape", "20% Off for 3+ nights", "Deluxe Suite", "20%"));
    }
}
