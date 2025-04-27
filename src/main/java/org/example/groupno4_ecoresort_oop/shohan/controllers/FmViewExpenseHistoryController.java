package org.example.groupno4_ecoresort_oop.shohan.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.shohan.dummyClasses.ExpenseHistory;

import java.util.ArrayList;
import java.util.List;

public class FmViewExpenseHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<ExpenseHistory, String> userType_TC;
    @javafx.fxml.FXML
    private TableView<ExpenseHistory> table_T;
    @javafx.fxml.FXML
    private TableColumn<ExpenseHistory, String> serialNo_TC;
    @javafx.fxml.FXML
    private TableColumn<ExpenseHistory, String> expenseOn_TC;
    @javafx.fxml.FXML
    private TableColumn<ExpenseHistory, String> expense_TC;

    @javafx.fxml.FXML
    public void initialize() {

        serialNo_TC.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
        userType_TC.setCellValueFactory(new PropertyValueFactory<>("userType"));
        expenseOn_TC.setCellValueFactory(new PropertyValueFactory<>("expenseOn"));
        expense_TC.setCellValueFactory(new PropertyValueFactory<>("expense"));

        List<ExpenseHistory> dummyExpenses = new ArrayList<>();
        dummyExpenses.add(new ExpenseHistory("1", "Finance Manager", "Marketing", "$1500"));
        dummyExpenses.add(new ExpenseHistory("2", "Finance Manager", "Infrastructure", "$2000"));
        dummyExpenses.add(new ExpenseHistory("3", "Finance Manager", "Events", "$1000"));
        dummyExpenses.add(new ExpenseHistory("4", "Finance Manager", "Electricity", "$750"));
        dummyExpenses.add(new ExpenseHistory("5", "Finance Manager", "Software License", "$500"));

        // Load data into TableView
        table_T.getItems().setAll(dummyExpenses);

        System.out.println("=== Dummy Expense History Loaded ===");
        for (ExpenseHistory expense : dummyExpenses) {
            System.out.println(expense);
        }
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
