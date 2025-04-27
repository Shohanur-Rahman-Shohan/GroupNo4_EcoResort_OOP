package org.example.groupno4_ecoresort_oop.nigar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LaunchCampignController {

    @FXML
    private Button launchcampign;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private TextField campaignNameField;

    @FXML
    private TextField budgetField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField statusField;

    @FXML
    private TextField categoryField;

    @FXML
    private TableView<Campaign> campaignTable;

    @FXML
    private TableColumn<Campaign, String> nameColumn;

    @FXML
    private TableColumn<Campaign, String> categoryColumn;

    @FXML
    private TableColumn<Campaign, String> statusColumn;

    @FXML
    private TableColumn<Campaign, String> budgetColumn;

    @FXML
    private TableColumn<Campaign, String> dateColumn;

    @FXML
    private TableColumn<Campaign, String> descriptionColumn;

    private Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(data -> data.getValue().campaignNameProperty());
        categoryColumn.setCellValueFactory(data -> data.getValue().categoryProperty());
        statusColumn.setCellValueFactory(data -> data.getValue().statusProperty());
        budgetColumn.setCellValueFactory(data -> data.getValue().budgetProperty());
        dateColumn.setCellValueFactory(data -> data.getValue().dateProperty());
        descriptionColumn.setCellValueFactory(data -> data.getValue().descriptionProperty());

        ObservableList<Campaign> campaigns = FXCollections.observableArrayList(loadCampaignsFromFile("campaigns.txt"));
        campaignTable.setItems(campaigns);
    }

    @FXML
    private void launchCampaign() {
        String name = campaignNameField.getText();
        String category = categoryField.getText();
        String status = statusField.getText();
        String budget = budgetField.getText();
        LocalDate date = datePicker.getValue();
        String description = descriptionArea.getText();

        String campaignData = String.format("%s,%s,%s,%s,%s,%s", name, category, status, budget, date, description);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("campaigns.txt", true))) {
            writer.write(campaignData);
            writer.newLine();
            System.out.println("Campaign saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }


        campaignTable.setItems(FXCollections.observableArrayList(loadCampaignsFromFile("campaigns.txt")));
    }

    private List<Campaign> loadCampaignsFromFile(String filename) {
        List<Campaign> campaignList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    campaignList.add(new Campaign(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return campaignList;
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
        System.out.println("launchcampign" );
    }

    @FXML
    public void switchSceneA(ActionEvent event) {
        switchScene("dashboard.fxml");
    }
}
