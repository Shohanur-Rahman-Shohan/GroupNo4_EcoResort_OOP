package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.AdventureSport;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class ManageAdventureSportsController {

    @javafx.fxml.FXML
    private TextField maxCapacityTextField;
    @javafx.fxml.FXML
    private TableColumn<AdventureSport, Integer> maxCapacityTableColumn;
    @javafx.fxml.FXML
    private TableView<AdventureSport> outputTableView;
    @javafx.fxml.FXML
    private ToggleGroup categoryToggleGroup;
    @javafx.fxml.FXML
    private TextField updatemaxCapacityTextField;
    @javafx.fxml.FXML
    private TextField activityNameTextField;
    @javafx.fxml.FXML
    private TableColumn<AdventureSport, String> statusTableColumn;
    @javafx.fxml.FXML
    private RadioButton landRadioButton;
    @javafx.fxml.FXML
    private TextField activityIdTextField;
    @javafx.fxml.FXML
    private RadioButton waterRadioButton;
    @javafx.fxml.FXML
    private RadioButton aerialRadioButton;
    @javafx.fxml.FXML
    private ComboBox<String> statusCombobox;
    @javafx.fxml.FXML
    private DatePicker scheduleDatePicker;
    @javafx.fxml.FXML
    private TableColumn<AdventureSport, LocalDate> scheduleTableColumn;
    @javafx.fxml.FXML
    private TableColumn<AdventureSport, String> categoryTableColumn;
    @javafx.fxml.FXML
    private TextField searchIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> updateStatusCombobox;
    @javafx.fxml.FXML
    private TableColumn<AdventureSport, String> activitynameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<AdventureSport, String> activityIdTableColumn;

    private final String FILE_PATH = "Data/arman/adventuresport.bin";

    @javafx.fxml.FXML
    public void initialize() {
        // Setup TableView columns
        categoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        maxCapacityTableColumn.setCellValueFactory(new PropertyValueFactory<>("maxCapacity"));
        activitynameTableColumn.setCellValueFactory(new PropertyValueFactory<>("activityName"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        scheduleTableColumn.setCellValueFactory(new PropertyValueFactory<>("schedule"));
        activityIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("activityId"));

        // Load adventure sports data from binary file
        List<AdventureSport> adventureSports = readAdventureSportsFromFile();
        outputTableView.getItems().addAll(adventureSports);

        // Populate the status combobox with available statuses
        statusCombobox.getItems().addAll("Available", "Unavailable");
        updateStatusCombobox.getItems().addAll("Available", "Unavailable");
    }

    @javafx.fxml.FXML
    public void addButtonOnAction(ActionEvent actionEvent) {
        String activityId = activityIdTextField.getText();
        String activityName = activityNameTextField.getText();
        String category = landRadioButton.isSelected() ? "Land" : waterRadioButton.isSelected() ? "Water" : "Aerial";
        int maxCapacity = Integer.parseInt(maxCapacityTextField.getText());
        String status = statusCombobox.getValue();
        LocalDate schedule = scheduleDatePicker.getValue();

        AdventureSport newSport = new AdventureSport(activityId, activityName, category, maxCapacity, status, schedule);

        // Save the new sport to the binary file
        List<AdventureSport> adventureSports = readAdventureSportsFromFile();
        adventureSports.add(newSport);
        writeAdventureSportsToFile(adventureSports);

        // Refresh the TableView
        outputTableView.getItems().clear();
        outputTableView.getItems().addAll(adventureSports);
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
        String activityId = searchIdTextField.getText();
        String newStatus = updateStatusCombobox.getValue();
        int newMaxCapacity = Integer.parseInt(updatemaxCapacityTextField.getText());

        List<AdventureSport> adventureSports = readAdventureSportsFromFile();
        boolean found = false;

        for (AdventureSport sport : adventureSports) {
            if (sport.getActivityId().equals(activityId)) {
                sport.setStatus(newStatus);
                sport.setMaxCapacity(newMaxCapacity);
                found = true;
                break;
            }
        }

        if (found) {
            writeAdventureSportsToFile(adventureSports);
            outputTableView.getItems().clear();
            outputTableView.getItems().addAll(adventureSports);

            // Show success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Adventure Sport Updated");
            alert.show();
        } else {
            // Show error message if not found
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Adventure Sport not found!");
            alert.show();
        }
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            // Scene switch back to the dashboard
            SceneSwitcher.switchTo("arman/ACDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to read all adventure sports from the binary file
    private List<AdventureSport> readAdventureSportsFromFile() {
        List<AdventureSport> adventureSports = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            adventureSports = (List<AdventureSport>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return adventureSports;
    }

    // Method to write all adventure sports to the binary file
    private void writeAdventureSportsToFile(List<AdventureSport> adventureSports) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(adventureSports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}