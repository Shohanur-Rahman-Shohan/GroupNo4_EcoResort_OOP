package org.example.groupno4_ecoresort_oop.Sadman;

import java.time.LocalDate;

public class AvailableRooms {
    private String roomType, bedP, ViewP;
    private double roomNo , price;
    private LocalDate checkOutDate, checkInDate;

    public AvailableRooms(String roomType, String bedP, String viewP, double roomNo, double price, LocalDate checkOutDate, LocalDate checkInDate) {
        this.roomType = roomType;
        this.bedP = bedP;
        ViewP = viewP;
        this.roomNo = roomNo;
        this.price = price;
        this.checkOutDate = checkOutDate;
        this.checkInDate = checkInDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedP() {
        return bedP;
    }

    public void setBedP(String bedP) {
        this.bedP = bedP;
    }

    public String getViewP() {
        return ViewP;
    }

    public void setViewP(String viewP) {
        ViewP = viewP;
    }

    public double getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(double roomNo) {
        this.roomNo = roomNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }


    @Override
    public String toString() {
        return "AvailableRooms{" +
                "roomType='" + roomType + '\'' +
                ", bedP='" + bedP + '\'' +
                ", ViewP='" + ViewP + '\'' +
                ", roomNo=" + roomNo +
                ", price=" + price +
                ", checkOutDate=" + checkOutDate +
                ", checkInDate=" + checkInDate +
                '}';
    }
}
