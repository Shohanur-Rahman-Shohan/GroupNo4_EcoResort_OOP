package org.example.groupno4_ecoresort_oop.arman.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.arman.TourGuide;
import org.example.groupno4_ecoresort_oop.arman.TourSchedule;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;



public class AssignTourGuideController {

    @javafx.fxml.FXML
    private TableColumn<TourGuide, String> guestIdTC;
    @javafx.fxml.FXML
    private TableColumn<TourGuide, String> tourGuideTC;
    @javafx.fxml.FXML
    private TableColumn<TourGuide, String> tourDayTC;
    @javafx.fxml.FXML
    private TableView<TourGuide> outputTableView;
    @javafx.fxml.FXML
    private ComboBox<String> availableGuideCombobox;
    @javafx.fxml.FXML
    private TextField tourIdTextField;

    private List<TourGuide> tourGuides;

    @javafx.fxml.FXML
    public void initialize() {

        guestIdTC.setCellValueFactory(new PropertyValueFactory<>("guestId"));
        tourDayTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        tourGuideTC.setCellValueFactory(new PropertyValueFactory<>("guideName"));
        createTourGuideFile();
        loadTourGuides();
        populateGuideComboBox();
    }

    private void loadTourGuides() {

        File file = new File("Data/arman/tourguide.bin");
        tourGuides = BinaryFileHelper.readAllObjects(file);


        outputTableView.getItems().clear();
        outputTableView.getItems().addAll(tourGuides);
    }

    private void populateGuideComboBox() {
        List<String> guideNames = new ArrayList<>();
        guideNames.add("GUIDE 1");
        guideNames.add("GUIDE 2");
        guideNames.add("GUIDE 3");
        guideNames.add("GUIDE 4");
        guideNames.add("GUIDE 5");
        guideNames.add("GUIDE 6");
        guideNames.add("GUIDE 7");
        guideNames.add("GUIDE 8");

        Random rand = new Random();
        for (int i = 0; i < guideNames.size(); i++) {
            int j = rand.nextInt(guideNames.size());
            String temp = guideNames.get(i);
            guideNames.set(i, guideNames.get(j));
            guideNames.set(j, temp);
        }


        availableGuideCombobox.getItems().clear();
        availableGuideCombobox.getItems().addAll(guideNames);
    }

    @javafx.fxml.FXML
    public void loadAvailableGuideOnAction(ActionEvent actionEvent) {
        String guestId = tourIdTextField.getText();
        if (!guestId.isEmpty()) {
            // Find the corresponding TourGuide by guestId
            TourGuide selectedGuide = null;
            for (TourGuide tg : tourGuides) {
                if (tg.getGuestId().equals(guestId)) {
                    selectedGuide = tg;
                    break;
                }
            }

            if (selectedGuide != null && selectedGuide.getGuideName() == null) {

                availableGuideCombobox.setDisable(false);


                List<String> assignedGuideNames = new ArrayList<>();
                for (TourGuide tg : tourGuides) {
                    if (tg.getGuideName() != null) {
                        assignedGuideNames.add(tg.getGuideName());
                    }
                }

                List<String> availableGuideNames = new ArrayList<>(availableGuideCombobox.getItems());
                availableGuideNames.removeAll(assignedGuideNames);
                availableGuideCombobox.getItems().clear();
                availableGuideCombobox.getItems().addAll(availableGuideNames);
            } else {
                // If a guide is already assigned, disable the ComboBox
                availableGuideCombobox.setDisable(true);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "This guest already has a tour guide assigned.");
                alert.showAndWait();
            }
        }
    }

    @javafx.fxml.FXML
    public void saveButtonOnAction(ActionEvent actionEvent) {
        String guestId = tourIdTextField.getText();
        String selectedGuideName = availableGuideCombobox.getValue();

        if (!guestId.isEmpty() && selectedGuideName != null) {

            TourGuide selectedGuide = null;
            for (TourGuide tg : tourGuides) {
                if (tg.getGuestId().equals(guestId)) {
                    selectedGuide = tg;
                    break;
                }
            }

            if (selectedGuide != null) {
                selectedGuide.setGuideName(selectedGuideName);
                File file = new File("Data/arman/tourguide.bin");
                BinaryFileHelper.writeAllObjects(file, tourGuides);
                loadTourGuides();
            }
        }
    }
    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("arman/ACDashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTourGuideFile() {
        File tourScheduleFile = new File("Data/arman/tourschedule.bin");
        File tourGuideFile = new File("Data/arman/tourguide.bin");
        List<TourSchedule> tourSchedules = BinaryFileHelper.readAllObjects(tourScheduleFile);
        List<TourGuide> tourGuides = new ArrayList<>();
        for (TourSchedule ts : tourSchedules) {
            TourGuide guide = new TourGuide(null, ts.getGuestId(), ts.getDate().toString());
            tourGuides.add(guide);
        }
        BinaryFileHelper.writeAllObjects(tourGuideFile, tourGuides);
        System.out.println("Tour guide data written to tourguide.bin with null guides.");
    }
}
