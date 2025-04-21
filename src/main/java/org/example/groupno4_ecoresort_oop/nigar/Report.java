package org.example.groupno4_ecoresort_oop.nigar;

import java.io.Serializable;
import java.util.List;

public class Report implements Serializable {
    private String date;
    private double revenue;
    private int sales;

    public Report(String date, double revenue, int sales) {
        this.date = date;
        this.revenue = revenue;
        this.sales = sales;
    }

    public static List<Report> getReportList() {
        return List.of();
    }

    public String getDate() {
        return date;
    }

    public double getRevenue() {
        return revenue;
    }

    public int getSales() {
        return sales;
    }
}
