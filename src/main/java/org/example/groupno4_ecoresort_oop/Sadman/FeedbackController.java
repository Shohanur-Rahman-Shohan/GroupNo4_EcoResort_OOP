package org.example.groupno4_ecoresort_oop.Sadman;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FeedbackController
{
    @javafx.fxml.FXML
    private TextArea commentTextArea;
    @javafx.fxml.FXML
    private TextField ReservationId;
    @javafx.fxml.FXML
    private RadioButton badRB;
    @javafx.fxml.FXML
    private RadioButton avgRB;
    @javafx.fxml.FXML
    private RadioButton goodRB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {
    }
}