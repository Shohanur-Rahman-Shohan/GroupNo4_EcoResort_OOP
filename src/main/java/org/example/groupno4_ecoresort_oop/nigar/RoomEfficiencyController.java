package org.example.groupno4_ecoresort_oop.nigar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;

import java.io.IOException;

public class RoomEfficiencyController {

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView<RoomInformation> roomTableView;

    @FXML
    private TableColumn<RoomInformation, String> roomNoColumn;

    @FXML
    private TableColumn<RoomInformation, String> timeScheduleColumn;

    @FXML
    private TableColumn<RoomInformation, String> statusColumn;

    @FXML
    private TableColumn<RoomInformation, String> lastCleanedColumn;

    private ObservableList<RoomInformation> roomStatusList = FXCollections.observableArrayList();

    Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    void initialize() {

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
        switchScene("nigar.controller/DashBoardController.fxml");
    }

}
