package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.Feedback;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackAndSuccessRateController {

    @javafx.fxml.FXML
    private TableColumn<Feedback, String> activityIdTC;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> comfortTC;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> safetyTC;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> enjoymentTC;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> successRateTC;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> additionalCommentTC;

    @javafx.fxml.FXML
    private TextField activityIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> comfortComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> safetyCombobox;
    @javafx.fxml.FXML
    private ComboBox<String> enjoymentComboBox;
    @javafx.fxml.FXML
    private TextField additionalCommentTextField;

    @javafx.fxml.FXML
    private TableView<Feedback> outputTableView;

    private final String FILE_PATH = "Data/arman/feedback.bin";

    @javafx.fxml.FXML
    public void initialize() {
        // Set up TableView columns
        activityIdTC.setCellValueFactory(new PropertyValueFactory<>("activityId"));
        comfortTC.setCellValueFactory(new PropertyValueFactory<>("comfort"));
        safetyTC.setCellValueFactory(new PropertyValueFactory<>("safety"));
        enjoymentTC.setCellValueFactory(new PropertyValueFactory<>("enjoyment"));
        successRateTC.setCellValueFactory(new PropertyValueFactory<>("successRate"));
        additionalCommentTC.setCellValueFactory(new PropertyValueFactory<>("additionalComment"));

        // Populate ComboBoxes with star ratings (★)
        comfortComboBox.getItems().addAll("★", "★★", "★★★", "★★★★", "★★★★★");
        safetyCombobox.getItems().addAll("★", "★★", "★★★", "★★★★", "★★★★★");
        enjoymentComboBox.getItems().addAll("★", "★★", "★★★", "★★★★", "★★★★★");

        // Load existing feedback data from binary file
        List<Feedback> feedbackList = readFeedbackFromFile();
        outputTableView.getItems().addAll(feedbackList);
    }

    @javafx.fxml.FXML
    public void giveFeedBackButtonOnAction(ActionEvent actionEvent) {
        String activityId = activityIdTextField.getText();
        String comfort = comfortComboBox.getValue();
        String safety = safetyCombobox.getValue();
        String enjoyment = enjoymentComboBox.getValue();
        String additionalComment = additionalCommentTextField.getText();

        // Create a new Feedback object
        Feedback newFeedback = new Feedback(activityId, getRating(comfort), getRating(safety), getRating(enjoyment), additionalComment);

        // Save the new feedback to the binary file
        List<Feedback> feedbackList = readFeedbackFromFile();
        feedbackList.add(newFeedback);
        writeFeedbackToFile(feedbackList);

        // Refresh TableView
        outputTableView.getItems().clear();
        outputTableView.getItems().addAll(feedbackList);
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("arman/ACDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert the star rating to an integer
    private int getRating(String starRating) {
        switch (starRating) {
            case "★★★★★":
                return 5;
            case "★★★★":
                return 4;
            case "★★★":
                return 3;
            case "★★":
                return 2;
            case "★":
                return 1;
            default:
                return 0;
        }
    }

    // Method to read feedback data from the binary file
    private List<Feedback> readFeedbackFromFile() {
        List<Feedback> feedbackList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            feedbackList = (List<Feedback>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();  // Handle the exception
        }
        return feedbackList;
    }

    // Method to write feedback data to the binary file
    private void writeFeedbackToFile(List<Feedback> feedbackList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(feedbackList);
        } catch (IOException e) {
            e.printStackTrace();  // Handle the exception
        }
    }
}
