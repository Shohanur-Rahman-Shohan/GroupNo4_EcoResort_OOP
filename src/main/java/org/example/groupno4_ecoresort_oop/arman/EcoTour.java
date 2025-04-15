package org.example.groupno4_ecoresort_oop.arman;

import java.time.LocalDate;

public class EcoTour {
    private String guestId;
    private String guestName;
    private String eventType;
    private String guestType;
    private int seatsReserved;
    private LocalDate date;
    private double price;

    public EcoTour(String guestId, String guestName, String eventType, String guestType, int seatsReserved, LocalDate date, double price) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.eventType = eventType;
        this.guestType = guestType;
        this.seatsReserved = seatsReserved;
        this.date =date;
        this.price = price;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public int getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(int seatsReserved) {
        this.seatsReserved = seatsReserved;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate Date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "EcoTour{" +
                "guestId='" + guestId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", eventType='" + eventType + '\'' +
                ", guestType='" + guestType + '\'' +
                ", seatsReserved=" + seatsReserved +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
