package org.example.groupno4_ecoresort_oop.shohan.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.shohan.dummyClasses.CostDistribution;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.util.List;

public class FmCostDistributionController {
    @javafx.fxml.FXML
    private TextField maintenanceTechnician_TF;
    @javafx.fxml.FXML
    private TextField gm_TF;
    @javafx.fxml.FXML
    private TextField housekeepingSupervisor_TF;
    @javafx.fxml.FXML
    private TextField marketingAndSales_TF;
    @javafx.fxml.FXML
    private TextField activityCoordinator_TF;

    File file = new File("Data/shohan/costDistribution.bin");

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

    @javafx.fxml.FXML
    public void update_OA(ActionEvent actionEvent) {
        int gm = Integer.parseInt(gm_TF.getText());
        int activityCoordinator = Integer.parseInt(activityCoordinator_TF.getText());
        int maintenanceTechnician = Integer.parseInt(maintenanceTechnician_TF.getText());
        int housekeepingSupervisor = Integer.parseInt(housekeepingSupervisor_TF.getText());
        int marketingAndSalesManagement = Integer.parseInt(marketingAndSales_TF.getText());

        int total = gm + activityCoordinator + maintenanceTechnician + housekeepingSupervisor + marketingAndSalesManagement;

        if (total > 100) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please Make Sure The Total is Less Than Or Equal to 100.");
            alert.showAndWait();
            return;
        }

        CostDistribution newCostDistribution = new CostDistribution(
                gm,
                activityCoordinator,
                maintenanceTechnician,
                housekeepingSupervisor,
                marketingAndSalesManagement
        );

        List<CostDistribution> existing = BinaryFileHelper.readAllObjects(file);
        existing.add(newCostDistribution);
        BinaryFileHelper.writeAllObjects(file, existing);

        try {
            SceneSwitcher.switchTo("shohan/controllers/fmViewDepertmentalDistributedCost");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
