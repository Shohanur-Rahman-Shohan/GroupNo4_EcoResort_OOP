package org.example.groupno4_ecoresort_oop.shohan.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.shohan.dummyClasses.CostDistribution;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FmViewDepertmentalDistributedCostController {
    @javafx.fxml.FXML
    private TableView<CostDistribution> table_T;
    @javafx.fxml.FXML
    private TableColumn<CostDistribution, Integer> gm_TV;
    @javafx.fxml.FXML
    private TableColumn<CostDistribution, Integer> hs_TV;
    @javafx.fxml.FXML
    private TableColumn<CostDistribution, Integer> ac_TV;
    @javafx.fxml.FXML
    private TableColumn<CostDistribution, Integer> mt_TV;
    @javafx.fxml.FXML
    private TableColumn<CostDistribution, Integer> ms_TV;

    File file = new File("Data/shohan/costDistribution.bin");
    ArrayList<CostDistribution> cost = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        gm_TV.setCellValueFactory(new PropertyValueFactory<>("gm"));
        ac_TV.setCellValueFactory(new PropertyValueFactory<>("activityCoordinator"));
        mt_TV.setCellValueFactory(new PropertyValueFactory<>("maintananceTechnician"));
        hs_TV.setCellValueFactory(new PropertyValueFactory<>("housekeepingSupervisor"));
        ms_TV.setCellValueFactory(new PropertyValueFactory<>("marketingAndSalesManagement"));

        if (!file.exists()) {
            List<CostDistribution> dummyCosts = new ArrayList<>();
            BinaryFileHelper.writeAllObjects(file, dummyCosts);
        }

        List<CostDistribution> readList = BinaryFileHelper.readAllObjects(file);
        cost.clear();
        cost.addAll(readList);
        table_T.getItems().setAll(cost);
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
