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
        // Initialize the table columns to map to the correct fields of TourGuide
        guestIdTC.setCellValueFactory(new PropertyValueFactory<>("guestId"));
        tourDayTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        tourGuideTC.setCellValueFactory(new PropertyValueFactory<>("guideName"));

        createTourGuideFile();
        // Read the tourguide.bin file and populate the table
        loadTourGuides();

        // Populate ComboBox with random guide names
        populateGuideComboBox();
    }

    private void loadTourGuides() {
        // Read the tourguide.bin file
        File file = new File("Data/arman/tourguide.bin");
        tourGuides = BinaryFileHelper.readAllObjects(file);

        // Add the tour guides to the table
        outputTableView.getItems().clear();
        outputTableView.getItems().addAll(tourGuides);
    }

    private void populateGuideComboBox() {
        // Add 5-6 random guide names to the ComboBox
        List<String> guideNames = new ArrayList<>();
        guideNames.add("GUIDE 1");
        guideNames.add("GUIDE 2");
        guideNames.add("GUIDE 3");
        guideNames.add("GUIDE 4");
        guideNames.add("GUIDE 5");
        guideNames.add("GUIDE 6");
        guideNames.add("GUIDE 7");
        guideNames.add("GUIDE 8");

        // Shuffle the list to add randomness
        Random rand = new Random();
        for (int i = 0; i < guideNames.size(); i++) {
            int j = rand.nextInt(guideNames.size());
            String temp = guideNames.get(i);
            guideNames.set(i, guideNames.get(j));
            guideNames.set(j, temp);
        }

        // Add to the ComboBox
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
                // Enable ComboBox if no guide is assigned
                availableGuideCombobox.setDisable(false);

                // Update ComboBox to exclude already assigned guides
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
            // Find the corresponding TourGuide and assign the selected guide
            TourGuide selectedGuide = null;
            for (TourGuide tg : tourGuides) {
                if (tg.getGuestId().equals(guestId)) {
                    selectedGuide = tg;
                    break;
                }
            }

            if (selectedGuide != null) {
                // Set the selected guide to the TourGuide object
                selectedGuide.setGuideName(selectedGuideName);

                // Save the updated list back to the tourguide.bin file
                File file = new File("Data/arman/tourguide.bin");
                BinaryFileHelper.writeAllObjects(file, tourGuides);

                // Reload the tour guides and update the table
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

        // Read the original tour schedules
        List<TourSchedule> tourSchedules = BinaryFileHelper.readAllObjects(tourScheduleFile);

        // Create a new list to hold the TourGuide objects
        List<TourGuide> tourGuides = new ArrayList<>();

        // For each TourSchedule, create a new TourGuide object with null guide name
        for (TourSchedule ts : tourSchedules) {
            TourGuide guide = new TourGuide(null, ts.getGuestId(), ts.getDate().toString());
            tourGuides.add(guide);
        }

        // Write the TourGuide objects to the new tourguide.bin file
        BinaryFileHelper.writeAllObjects(tourGuideFile, tourGuides);
        System.out.println("Tour guide data written to tourguide.bin with null guides.");
    }
}
