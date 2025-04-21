package org.example.groupno4_ecoresort_oop.nigar;

public class Booking {
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

    public String getRoomNo() {
        return roomNo;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCheckInOut() {
        return checkInOut;
    }
}
