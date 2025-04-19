package org.example.groupno4_ecoresort_oop.arman;

import java.io.Serializable;
import java.time.LocalDate;

public class RepairRequest implements Serializable {
    private String requestId;
    private String location;
    private String type;
    private String status;
    private LocalDate requestDate;
    private String emergency;

    public RepairRequest(String requestId, String location, String type, String status, LocalDate requestDate, String emergency) {
        this.requestId = requestId;
        this.location = location;
        this.type = type;
        this.status = status;
        this.requestDate = requestDate;
        this.emergency = emergency;
    }

    public String getRequestId() { return requestId; }
    public String getLocation() { return location; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public LocalDate getRequestDate() { return requestDate; }
    public String getEmergency() { return emergency; }

    public void setStatus(String status) { this.status = status; }
    public void setEmergency(String emergency) { this.emergency = emergency; }
}