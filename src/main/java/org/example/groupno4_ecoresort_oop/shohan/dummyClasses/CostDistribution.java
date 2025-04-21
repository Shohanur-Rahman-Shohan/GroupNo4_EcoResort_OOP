package org.example.groupno4_ecoresort_oop.shohan.dummyClasses;

import java.io.Serializable;

public class CostDistribution implements Serializable {
    private int gm;
    private int activityCoordinator;
    private int maintananceTechnician;
    private int housekeepingSupervisor;
    private int marketingAndSalesManagement;

    public CostDistribution(int gm, int activityCoordinator, int maintananceTechnician, int housekeepingSupervisor, int marketingAndSalesManagement) {
        this.gm = gm;
        this.activityCoordinator = activityCoordinator;
        this.maintananceTechnician = maintananceTechnician;
        this.housekeepingSupervisor = housekeepingSupervisor;
        this.marketingAndSalesManagement = marketingAndSalesManagement;
    }


    public int getGm() {
        return gm;
    }

    public void setGm(int gm) {
        this.gm = gm;
    }

    public int getActivityCoordinator() {
        return activityCoordinator;
    }

    public void setActivityCoordinator(int activityCoordinator) {
        this.activityCoordinator = activityCoordinator;
    }

    public int getMaintananceTechnician() {
        return maintananceTechnician;
    }

    public void setMaintananceTechnician(int maintananceTechnician) {
        this.maintananceTechnician = maintananceTechnician;
    }

    public int getHousekeepingSupervisor() {
        return housekeepingSupervisor;
    }

    public void setHousekeepingSupervisor(int housekeepingSupervisor) {
        this.housekeepingSupervisor = housekeepingSupervisor;
    }

    public int getMarketingAndSalesManagement() {
        return marketingAndSalesManagement;
    }

    public void setMarketingAndSalesManagement(int marketingAndSalesManagement) {
        this.marketingAndSalesManagement = marketingAndSalesManagement;
    }
}
