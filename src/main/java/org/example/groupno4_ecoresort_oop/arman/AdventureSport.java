package org.example.groupno4_ecoresort_oop.arman;

import java.io.Serializable;
import java.time.LocalDate;

public class AdventureSport implements Serializable {
    private String activityId;
    private String activityName;
    private String category;
    private int maxCapacity;
    private String status;
    private LocalDate schedule;

    // Constructor
    public AdventureSport(String activityId, String activityName, String category, int maxCapacity, String status, LocalDate schedule) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.category = category;
        this.maxCapacity = maxCapacity;
        this.status = status;
        this.schedule = schedule;
    }

    // Getters and Setters
    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }
}
