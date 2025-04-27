package org.example.groupno4_ecoresort_oop.nigar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {

    private final StringProperty staffId;
    private final StringProperty task;
    private final StringProperty roomNumber;
    private final StringProperty time;
    private final StringProperty date;


    public Task(String staffId, String task, String roomNumber, String time, String date) {
        this.staffId = new SimpleStringProperty(staffId);
        this.task = new SimpleStringProperty(task);
        this.roomNumber = new SimpleStringProperty(roomNumber);
        this.time = new SimpleStringProperty(time);
        this.date = new SimpleStringProperty(date);
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

    public String getTask() {
        return task.get();
    }

    public StringProperty taskProperty() {
        return task;
    }

    public void setTask(String task) {
        this.task.set(task);
    }

    public String getRoomNumber() {
        return roomNumber.get();
    }

    public StringProperty roomNumberProperty() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber.set(roomNumber);
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

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
