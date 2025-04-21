package org.example.groupno4_ecoresort_oop.nigar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class marketingdashboard {

    @FXML
    private void handleViewReports(ActionEvent event) throws IOException {
        switchScene(event, "LaunchCampaigns.fxml");
    }

    @FXML
    private void handleManageCampaigns(ActionEvent event) throws IOException {
        switchScene(event, "ManageOnlinePresence.fxml");
    }

    @FXML
    private void handleViewFeedback(ActionEvent event) throws IOException {
        switchScene(event, "TrackOccupancy.fxml");
    }

    @FXML
    private void handleMarketAnalytics(ActionEvent event) throws IOException {
        switchScene(event, "MonitorBookingList.fxml");
    }

    @FXML
    private void handlePromotions(ActionEvent event) throws IOException {
        switchScene(event, "PromoteOffers.fxml");
    }

    @FXML
    private void handleSalesTeamPerformance(ActionEvent event) throws IOException {
        switchScene(event, "CollaborateAgencies.fxml");
    }

    @FXML
    private void handleDigitalMarketing(ActionEvent event) throws IOException {
        switchScene(event, "TrackReviews.fxml");
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        switchScene(event, "SalesDataAnalysis.fxml");
    }

    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Scene newScene = new Scene(loader.load());
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newScene);
        currentStage.show();
    }
}
