package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.AssignedRepairTask;
import org.example.groupno4_ecoresort_oop.shohan.dummyClasses.ExpenseHistory;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.*;
import java.util.*;


public class AssignRepairTaskController {

    @FXML private TableView<AssignedRepairTask> outputTableView;
    @FXML private TableColumn<AssignedRepairTask, String> requestIdTC;
    @FXML private TableColumn<AssignedRepairTask, String> requestTypeTC;
    @FXML private TableColumn<AssignedRepairTask, String> assignToTC;

    @FXML private ComboBox<String> requestTypeCombobox;
    @FXML private ComboBox<String> availableTeamForTheTypeCombobox;
    @FXML private TextField requestIdTextField;

    private final ObservableList<AssignedRepairTask> taskList = FXCollections.observableArrayList();
    private final Map<String, ObservableList<String>> typeToTeamsMap = new HashMap<>();
    private final File file = new File("assigned_tasks.bin");

    @FXML
    public void initialize() {
        requestTypeTC.setCellValueFactory(new PropertyValueFactory<>("requestType"));
        requestIdTC.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        assignToTC.setCellValueFactory(new PropertyValueFactory<>("assignTo"));

        outputTableView.setItems(taskList);

        requestTypeCombobox.setItems(FXCollections.observableArrayList("Plumbing", "Electrical", "Carpentry", "Cleaning"));
        setupTeams();
        loadAssignedTasks();

        requestTypeCombobox.setOnAction(e -> {
            String selectedType = requestTypeCombobox.getValue();
            availableTeamForTheTypeCombobox.setItems(typeToTeamsMap.getOrDefault(selectedType, FXCollections.observableArrayList()));
        });
    }

    private void setupTeams() {
        typeToTeamsMap.put("Plumbing", FXCollections.observableArrayList("Plumber Team A", "Plumber Team B", "Plumber Team C", "Plumber Team D"));
        typeToTeamsMap.put("Electrical", FXCollections.observableArrayList("Electric Team A", "Electric Team B", "Electric Team C", "Electric Team D"));
        typeToTeamsMap.put("Carpentry", FXCollections.observableArrayList("Carpenters United", "WoodFix Team"));
        typeToTeamsMap.put("Cleaning", FXCollections.observableArrayList("CleanPro", "EcoClean"));
    }

    @FXML
    public void AssignButtonOnAction(ActionEvent actionEvent) {
        String requestId = requestIdTextField.getText();
        String requestType = requestTypeCombobox.getValue();
        String assignedTeam = availableTeamForTheTypeCombobox.getValue();

        if (requestId.isEmpty() || requestType == null || assignedTeam == null) {
            showAlert("Missing Fields", "Please fill all fields before assigning.");
            return;
        }

        // Add task to table and save it
        AssignedRepairTask task = new AssignedRepairTask(requestId, requestType, assignedTeam);
        taskList.add(task);
        saveAssignedTasks();

    }

    private void saveAssignedTasks() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(new ArrayList<>(taskList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAssignedTasks() {
        if (!file.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = in.readObject();
            if (obj instanceof List<?>) {
                taskList.addAll((List<AssignedRepairTask>) obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("arman/MTDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
