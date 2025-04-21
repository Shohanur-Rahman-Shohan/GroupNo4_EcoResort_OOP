package org.example.groupno4_ecoresort_oop.shohan;

import java.io.Serializable;
import java.time.LocalDate;

public class Event implements Serializable {
    private String event;
    private int noOfSeat;
    private int eventCost;
    private LocalDate eventDate;
    private String guestCatagory;


    public Event(String event, int noOfSeat, int eventCost, LocalDate eventDate, String guestCatagory) {
        this.event = event;
        this.noOfSeat = noOfSeat;
        this.eventCost = eventCost;
        this.eventDate = eventDate;
        this.guestCatagory = guestCatagory;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getNoOfSeat() {
        return noOfSeat;
    }

    public void setNoOfSeat(int noOfSeat) {
        this.noOfSeat = noOfSeat;
    }

    public int getEventCost() {
        return eventCost;
    }

    public void setEventCost(int eventCost) {
        this.eventCost = eventCost;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getGuestCatagory() {
        return guestCatagory;
    }

    public void setGuestCatagory(String guestCatagory) {
        this.guestCatagory = guestCatagory;
    }


    @Override
    public String toString() {
        return "Event{" +
                "event='" + event + '\'' +
                ", noOfSeat=" + noOfSeat +
                ", eventCost=" + eventCost +
                ", eventDate=" + eventDate +
                ", guestCatagory='" + guestCatagory + '\'' +
                '}';
    }
}
