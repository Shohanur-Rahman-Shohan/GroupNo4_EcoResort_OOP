package org.example.groupno4_ecoresort_oop.nigar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RoomStatus {
    private final StringProperty roomNo;
    private final StringProperty timeSchedule;
    private final StringProperty progress;
    private final StringProperty maintenance;
    private final StringProperty feedback;
    private final StringProperty notification;

    public RoomStatus(String roomNo, String timeSchedule, String progress, String maintenance, String feedback, String notification) {
        this.roomNo = new SimpleStringProperty(roomNo);
        this.timeSchedule = new SimpleStringProperty(timeSchedule);
        this.progress = new SimpleStringProperty(progress);
        this.maintenance = new SimpleStringProperty(maintenance);
        this.feedback = new SimpleStringProperty(feedback);
        this.notification = new SimpleStringProperty(notification);
    }

    public StringProperty roomNoProperty() { return roomNo; }
    public StringProperty timeScheduleProperty() { return timeSchedule; }
    public StringProperty progressProperty() { return progress; }
    public StringProperty maintenanceProperty() { return maintenance; }
    public StringProperty feedbackProperty() { return feedback; }
    public StringProperty notificationProperty() { return notification; }
}


