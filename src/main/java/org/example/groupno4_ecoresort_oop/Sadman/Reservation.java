package org.example.groupno4_ecoresort_oop.Sadman;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Reservation {
    private String reservationId;
    private String guestName;
    private String email;
    private String phone;
    private String roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalPrice;

    public Reservation(String reservationId, String guestName, String email, String phone,
                       String roomNumber, LocalDate checkInDate, LocalDate checkOutDate, double totalPrice) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.email = email;
        this.phone = phone;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
