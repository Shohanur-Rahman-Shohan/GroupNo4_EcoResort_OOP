package org.example.groupno4_ecoresort_oop.arman;

import java.io.Serializable;
import java.time.LocalDate;

public class TourSchedule implements Serializable {
    private String guestId;
    private String guestName;
    private LocalDate date;
    private String eventtype;
    private String guestType;
    private int seatReserver;
    private double price;

    public TourSchedule(String guestId, String guestName, LocalDate date, String eventtype, String guestType, int seatReserver, double price) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.date = date;
        this.eventtype = eventtype;
        this.guestType = guestType;
        this.seatReserver = seatReserver;
        this.price = price;
    }

    public TourSchedule() {
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public int getSeatReserver() {
        return seatReserver;
    }

    public void setSeatReserver(int seatReserver) {
        this.seatReserver = seatReserver;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TourSchedule{" +
                "guestId='" + guestId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", date=" + date +
                ", eventtype='" + eventtype + '\'' +
                ", guestType='" + guestType + '\'' +
                ", seatReserver=" + seatReserver +
                ", price=" + price +
                '}';
    }
}
