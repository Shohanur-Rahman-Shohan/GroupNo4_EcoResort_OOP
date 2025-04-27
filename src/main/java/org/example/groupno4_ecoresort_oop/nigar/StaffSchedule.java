package org.example.groupno4_ecoresort_oop.nigar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StaffSchedule {

    private StringProperty staffId;
    private StringProperty room;
    private StringProperty shift;
    private StringProperty time;


    public StaffSchedule(String staffId, String room, String shift, String time) {
        this.staffId = new SimpleStringProperty(staffId);
        this.room = new SimpleStringProperty(room);
        this.shift = new SimpleStringProperty(shift);
        this.time = new SimpleStringProperty(time);
    }

    public String getStaffId() {
        return staffId.get();
    }

    public StringProperty staffIdProperty() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId.set(staffId);
    }

    public String getRoom() {
        return room.get();
    }

    public StringProperty roomProperty() {
        return room;
    }

    public void setRoom(String room) {
        this.room.set(room);
    }

    public String getShift() {
        return shift.get();
    }

    public StringProperty shiftProperty() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift.set(shift);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }
}
