package org.example.groupno4_ecoresort_oop.user;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import org.example.groupno4_ecoresort_oop.SceneSwitcher;
import org.example.groupno4_ecoresort_oop.shohan.managers.Manager;

public class DashBoardController
{
    @javafx.fxml.FXML
    private Menu gm_MB;

    @javafx.fxml.FXML
    private Menu home_MB;
    private Manager currentManager;

    @javafx.fxml.FXML
    private Menu fm_MB;
    @javafx.fxml.FXML
    private BorderPane dashboard_BP;
    @javafx.fxml.FXML
    private Button signOutt_OA;


    @javafx.fxml.FXML
    public void initialize() {
    }





    @javafx.fxml.FXML
    public void realTimeExpense_OA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void manageAdvanture_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/ManageEvent");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void addAdvanture_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/AddEvent");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void manageRoomCapacir(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/ManageRoomCapacity");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void roomOccupancy_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/RoomOccupancy");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void manageEventProfit_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/fmManageEventProfit");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void guestSatisfaction_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/GuestSatisfaction");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void compareFinance_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/fmCompareFinancials");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void vipRequest_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/VipService");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void crisisManagement_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/CrisisManagement");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void signOut_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("user/LoginView");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void guestProfitablity_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/fmCompareGuestProfitability");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void analizeAdjustServicePrice_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/fmAnalize&AdjustServicePrices");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void trackCarbonCredit_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/fmTrackCarbonCredits");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void workforceEfficiency_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/WorkforceEfficiency");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void emergencySpecialfund_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/fmManageSpecialFunds");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void depertmentalCost_OA(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo("shohan/controllers/fmCostDistribution");
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void viewFinanceSummary_OA(ActionEvent actionEvent) {
    }
}