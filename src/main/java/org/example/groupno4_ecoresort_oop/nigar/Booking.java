package org.example.groupno4_ecoresort_oop.nigar;

import java.io.Serializable;

public class Booking implements Serializable {
    private String guestName;
    private String roomNo;
    private String bookingId;
    private String checkInOut;

    public Booking(String guestName, String roomNo, String bookingId, String checkInOut) {
        this.guestName = guestName;
        this.roomNo = roomNo;
        this.bookingId = bookingId;
        this.checkInOut = checkInOut;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCheckInOut() {
        return checkInOut;
    }

    public void setCheckInOut(String checkInOut) {
        this.checkInOut = checkInOut;
    }
}
