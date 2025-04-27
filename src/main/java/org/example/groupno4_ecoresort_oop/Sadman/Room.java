package org.example.groupno4_ecoresort_oop.Sadman;

public class Room {
    private String roomNumber;
    private String roomType;
    private String bedType;
    private String viewType;
    private double pricePerNight;
    private boolean isAvailable;

    public Room(String roomNumber, String roomType, String bedType, String viewType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.bedType = bedType;
        this.viewType = viewType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", bedType='" + bedType + '\'' +
                ", viewType='" + viewType + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
