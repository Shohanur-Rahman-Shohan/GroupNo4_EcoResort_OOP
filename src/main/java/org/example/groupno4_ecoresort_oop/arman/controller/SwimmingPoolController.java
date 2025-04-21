package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.SwimmingPoolTestResult;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SwimmingPoolController {
    @javafx.fxml.FXML private TextField remarksTextField;
    @javafx.fxml.FXML private TextField chlorinLevelTextField;
    @javafx.fxml.FXML private TextField phLevelTextField;
    @javafx.fxml.FXML private DatePicker testDateDatePicker;

    @javafx.fxml.FXML private TableView<SwimmingPoolTestResult> swimmingPoolTableView;
    @javafx.fxml.FXML private TableColumn<SwimmingPoolTestResult, LocalDate> testDateTC;
    @javafx.fxml.FXML private TableColumn<SwimmingPoolTestResult, String> chlorinTC;
    @javafx.fxml.FXML private TableColumn<SwimmingPoolTestResult, String> phLevelTC;
    @javafx.fxml.FXML private TableColumn<SwimmingPoolTestResult, String> remarksTC;

    private final String FILE_PATH = "pool_test_results.bin";
    private ObservableList<SwimmingPoolTestResult> resultList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        testDateTC.setCellValueFactory(new PropertyValueFactory<>("testDate"));
        chlorinTC.setCellValueFactory(new PropertyValueFactory<>("chlorineLevel"));
        phLevelTC.setCellValueFactory(new PropertyValueFactory<>("phLevel"));
        remarksTC.setCellValueFactory(new PropertyValueFactory<>("remarks"));

        loadFromFile();
        swimmingPoolTableView.setItems(resultList);
    }

    @javafx.fxml.FXML
    public void saveTestResultButtonOnAction(ActionEvent actionEvent) {
        LocalDate date = testDateDatePicker.getValue();
        String chlorine = chlorinLevelTextField.getText();
        String ph = phLevelTextField.getText();
        String remarks = remarksTextField.getText();

        if (date == null || chlorine.isEmpty() || ph.isEmpty()) {
            showAlert("Test Date, Chlorine Level, and pH Level are required!");
            return;
        }

        SwimmingPoolTestResult result = new SwimmingPoolTestResult(date, chlorine, ph, remarks);
        resultList.add(result);
        saveToFile();
        swimmingPoolTableView.refresh();
        clearInputs();
    }

    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(new ArrayList<>(resultList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            ArrayList<SwimmingPoolTestResult> list = (ArrayList<SwimmingPoolTestResult>) in.readObject();
            resultList.setAll(list);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void clearInputs() {
        testDateDatePicker.setValue(null);
        chlorinLevelTextField.clear();
        phLevelTextField.clear();
        remarksTextField.clear();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void BackButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("arman/MTDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}