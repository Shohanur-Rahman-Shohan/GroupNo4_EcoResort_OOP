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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;

import java.io.IOException;

public class TrackOnlineReviewandFeedbackController {

    @FXML
    private TableView<ReviewEntry> tableView;

    @FXML
    private TableColumn<ReviewEntry, String> guestNameColumn;

    @FXML
    private TableColumn<ReviewEntry, String> reviewColumn;

    @FXML
    private TableColumn<ReviewEntry, Integer> ratingColumn;

    @FXML
    private TableColumn<ReviewEntry, String> replyColumn;

    @FXML
    private TableColumn<ReviewEntry, String> dateColumn;

    @FXML
    private TextField positiveReviewField;

    @FXML
    private TextField negativeReviewField;

    private final ObservableList<ReviewEntry> reviewList = FXCollections.observableArrayList();

    Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    void initialize() {

        guestNameColumn.setCellValueFactory(cellData -> cellData.getValue().guestNameProperty());
        reviewColumn.setCellValueFactory(cellData -> cellData.getValue().reviewProperty());
        ratingColumn.setCellValueFactory(cellData -> cellData.getValue().ratingProperty().asObject());
        replyColumn.setCellValueFactory(cellData -> cellData.getValue().replyProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());


    }


    private void loadReviewData() {

        reviewList.add(new ReviewEntry("John Doe", "Excellent service!", 5, "Thank you for your feedback!", "2025-04-18"));
        reviewList.add(new ReviewEntry("Jane Smith", "Room was a bit cold.", 3, "We apologize for the inconvenience!", "2025-04-17"));
        reviewList.add(new ReviewEntry("Alice Brown", "Great experience overall!", 4, "Thanks for your review!", "2025-04-16"));


    }


    @FXML
    private void submitPositiveReview(ActionEvent event) {
        String positiveReview = positiveReviewField.getText();
        if (!positiveReview.isEmpty()) {
            reviewList.add(new ReviewEntry("Anonymous", positiveReview, 5, "Thank you for your feedback!", "2025-04-18"));
            positiveReviewField.clear();
        }
    }


    @FXML
    private void submitNegativeReview(ActionEvent event) {
        String negativeReview = negativeReviewField.getText();
        if (!negativeReview.isEmpty()) {
            reviewList.add(new ReviewEntry("Anonymous", negativeReview, 2, "We're sorry for the inconvenience!", "2025-04-18"));
            negativeReviewField.clear(); 
        }
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
    private void switchToDashboard(ActionEvent event) {
        switchScene("nigar.controller/DashBoardController.fxml");
    }
}


