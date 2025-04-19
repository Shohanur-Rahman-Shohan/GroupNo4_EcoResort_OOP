package org.example.groupno4_ecoresort_oop.shohan.controllers;

import javafx.event.ActionEvent;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;

public class AddEventController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("user/DashBoard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}