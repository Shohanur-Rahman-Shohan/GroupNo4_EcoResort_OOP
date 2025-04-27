package org.example.groupno4_ecoresort_oop.arman;

import java.io.Serializable;

public class AssignedRepairTask implements Serializable {
    private String requestId;
    private String requestType;
    private String assignTo;

    public AssignedRepairTask(String requestId, String requestType, String assignTo) {
        this.requestId = requestId;
        this.requestType = requestType;
        this.assignTo = assignTo;
    }

    public String getRequestId() {
        return requestId;
    }
    public String getRequestType() {
        return requestType;
    }

    public String getAssignTo() {
        return assignTo;
    }
}