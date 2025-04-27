package org.example.groupno4_ecoresort_oop.Sadman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class FeedbackController {

    @FXML private TextField reservationIdField;
    @FXML private TextArea commentsArea;
    @FXML private RadioButton goodRadio;
    @FXML private RadioButton averageRadio;
    @FXML private RadioButton badRadio;
    @FXML private Button submitButton;
    @FXML private Button backButton;

    private ToggleGroup ratingGroup;

    @FXML
    private void initialize() {
        ratingGroup = new ToggleGroup();
        goodRadio.setToggleGroup(ratingGroup);
        averageRadio.setToggleGroup(ratingGroup);
        badRadio.setToggleGroup(ratingGroup);
    }

    @FXML
    private void handleSubmit() {
        String reservationId = reservationIdField.getText();
        String comments = commentsArea.getText();
        String rating = getSelectedRating();

        if (reservationId.isEmpty() || rating == null) {
            showAlert("Error", "Reservation ID and rating are required");
            return;
        }

        System.out.println("Feedback submitted for reservation: " + reservationId);
        System.out.println("Rating: " + rating);
        System.out.println("Comments: " + comments);

        showAlert("Thank You", "Your feedback has been submitted");
        clearForm();
    }

    private String getSelectedRating() {
        RadioButton selected = (RadioButton) ratingGroup.getSelectedToggle();
        return selected != null ? selected.getText() : null;
    }

    @FXML
    private void handleBack() throws Exception {
        loadScene("Guest/GD.fxml");
    }

    private void clearForm() {
        reservationIdField.clear();
        commentsArea.clear();
        ratingGroup.selectToggle(null);
    }

    private void loadScene(String fxmlFile) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}