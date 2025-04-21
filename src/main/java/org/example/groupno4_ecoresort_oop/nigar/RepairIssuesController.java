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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.HelloApplication;

import java.io.IOException;

public class RepairIssuesController {

    @FXML
    private TextArea textArea;

    @FXML
    private TableView<IssueData> tableView;

    @FXML
    private TableColumn<IssueData, String> issuesColumn;

    @FXML
    private TableColumn<IssueData, String> statusColumn;

    @FXML
    private Button logout;

    private final ObservableList<IssueData> issuesList = FXCollections.observableArrayList();

    private final Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    public void initialize() {
        issuesColumn.setCellValueFactory(cellData -> cellData.getValue().issueProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        tableView.setItems(issuesList);

    }

    @FXML
    private void switch1(ActionEvent event) {
        switchScene("/org/example/groupno4_ecoresort_oop/nigar/DashBoard.fxml");
    }

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
    private void onAddIssueClicked(ActionEvent event) {
        String issueText = textArea.getText().trim();
        if (!issueText.isEmpty()) {
            issuesList.add(new IssueData(issueText, "Pending"));
            textArea.clear();
        }
    }

    private void loadDummyIssues() {
        issuesList.add(new IssueData("Leaking pipe in Room 204", "Pending"));
        issuesList.add(new IssueData("Broken window in lobby", "Resolved"));
        issuesList.add(new IssueData("AC not working in Room 302", "Pending"));
    }
}


