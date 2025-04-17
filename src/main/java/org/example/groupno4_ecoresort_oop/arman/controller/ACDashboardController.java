package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;

public class ACDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void trackGuestParticipationButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/TrackGuestParticipation");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void modifyExistingTourButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/TourScheduleView");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void feedbackAndSuccessRateButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/FeedbackandSuccessRate");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void scheduleEcoTourButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/TourScheduleView");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void manageAdventureSportsButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/ManageAdventureSports");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void updateTourAndPriceButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("arman/UpdateTourAndPriceView");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void resolveComplaintsButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("ResolveComplaints");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void assignTourGuideButtonOnClick(Event event) {
        try {
            SceneSwitcher.switchTo("AssignTourGuide");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("user/LoginView");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}