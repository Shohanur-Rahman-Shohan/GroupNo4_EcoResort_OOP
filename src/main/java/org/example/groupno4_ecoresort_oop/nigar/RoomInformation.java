package org.example.groupno4_ecoresort_oop.nigar;

public class RoomInformation {
    private String roomNumber;
    private String timeSchedule;
    private String status;
    private String lastCleaned;


    public RoomInformation(String roomNumber, String timeSchedule, String status, String lastCleaned) {
        this.roomNumber = roomNumber;
        this.timeSchedule = timeSchedule;
        this.status = status;
        this.lastCleaned = lastCleaned;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getTimeSchedule() {
        return timeSchedule;
    }

    public void setTimeSchedule(String timeSchedule) {
        this.timeSchedule = timeSchedule;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastCleaned() {
        return lastCleaned;
    }

    public void setLastCleaned(String lastCleaned) {
        this.lastCleaned = lastCleaned;
    }
}
