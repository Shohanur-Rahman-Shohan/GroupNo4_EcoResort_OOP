package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.RepairRequest;
import java.io.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class MonthlyReportController {

    @FXML
    private PieChart outputLabelMonthly;

    @FXML
    private PieChart outputLabelyerly;

    @FXML
    private ComboBox<String> selectYearComboBox;

    @FXML
    private ComboBox<String> selectMonthComboBox;

    private final String FILE_PATH = "repair_requests.bin";
    private List<RepairRequest> repairRequests = new ArrayList<>();

    @FXML
    public void initialize() {
        loadRepairRequests();

        // Extract unique years and months from data
        Set<String> years = new HashSet<>();
        Set<String> months = new HashSet<>();

        for (RepairRequest req : repairRequests) {
            LocalDate date = req.getRequestDate();
            if (date != null) {
                years.add(String.valueOf(date.getYear()));
                months.add(date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
            }
        }

        selectYearComboBox.setItems(FXCollections.observableArrayList(years));
        selectMonthComboBox.setItems(FXCollections.observableArrayList(months));
    }

    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("arman/MTDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onActionMonthly(ActionEvent actionEvent) {
        String selectedMonth = selectMonthComboBox.getValue();
        String selectedYear = selectYearComboBox.getValue();

        if (selectedMonth == null || selectedYear == null) {
            showAlert("Please select both month and year.");
            return;
        }

        Map<String, Integer> typeCountMap = new HashMap<>();

        for (RepairRequest req : repairRequests) {
            LocalDate date = req.getRequestDate();
            if (date != null &&
                    date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).equals(selectedMonth) &&
                    String.valueOf(date.getYear()).equals(selectedYear)) {

                String type = req.getType();
                typeCountMap.put(type, typeCountMap.getOrDefault(type, 0) + 1);
            }
        }

        populatePieChart(outputLabelMonthly, typeCountMap);
    }

    @FXML
    public void onActionYearly(ActionEvent actionEvent) {
        String selectedYear = selectYearComboBox.getValue();

        if (selectedYear == null) {
            showAlert("Please select a year.");
            return;
        }

        Map<String, Integer> typeCountMap = new HashMap<>();

        for (RepairRequest req : repairRequests) {
            LocalDate date = req.getRequestDate();
            if (date != null && String.valueOf(date.getYear()).equals(selectedYear)) {
                String type = req.getType();
                typeCountMap.put(type, typeCountMap.getOrDefault(type, 0) + 1);
            }
        }

        populatePieChart(outputLabelyerly, typeCountMap);
    }

    private void populatePieChart(PieChart chart, Map<String, Integer> data) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }
        chart.setData(pieChartData);
    }

    private void loadRepairRequests() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = in.readObject();
            if (obj instanceof ArrayList<?>) {
                for (Object item : (ArrayList<?>) obj) {
                    if (item instanceof RepairRequest) {
                        repairRequests.add((RepairRequest) item);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}