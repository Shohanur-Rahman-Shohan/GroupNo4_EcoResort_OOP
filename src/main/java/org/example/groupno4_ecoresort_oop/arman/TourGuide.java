package org.example.groupno4_ecoresort_oop.arman;

import java.io.Serializable;
public class TourGuide implements Serializable {
    private String guideName;
    private String guestId;
    private String date;

    public TourGuide(String guideName, String guestId, String date) {
        this.guideName = guideName;
        this.guestId = guestId;
        this.date = date;
    }
    public String getGuideName() {
        return guideName;
    }
    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getGuestId() {
        return guestId;
    }
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return guideName;
    }
}
