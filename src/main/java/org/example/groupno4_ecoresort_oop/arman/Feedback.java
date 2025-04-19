package org.example.groupno4_ecoresort_oop.arman;

import java.io.Serializable;

public class Feedback implements Serializable {
    private String activityId;
    private int comfort;
    private int safety;
    private int enjoyment;
    private String additionalComment;
    private String successRate;

    public Feedback(String activityId, int comfort, int safety, int enjoyment, String additionalComment) {
        this.activityId = activityId;
        this.comfort = comfort;
        this.safety = safety;
        this.enjoyment = enjoyment;
        this.additionalComment = additionalComment;
        this.successRate = calculateSuccessRate();
    }

    private String calculateSuccessRate() {
        if (comfort >= 3 && safety >= 3 && enjoyment >= 3) {
            return "High";
        } else {
            return "Low";
        }
    }

    // Getters and Setters
    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public int getComfort() {
        return comfort;
    }

    public void setComfort(int comfort) {
        this.comfort = comfort;
        this.successRate = calculateSuccessRate();
    }

    public int getSafety() {
        return safety;
    }

    public void setSafety(int safety) {
        this.safety = safety;
        this.successRate = calculateSuccessRate();
    }

    public int getEnjoyment() {
        return enjoyment;
    }

    public void setEnjoyment(int enjoyment) {
        this.enjoyment = enjoyment;
        this.successRate = calculateSuccessRate();
    }

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    public String getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(String successRate) {
        this.successRate = successRate;
    }
}

