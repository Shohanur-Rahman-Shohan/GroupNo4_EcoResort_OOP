
   package org.example.groupno4_ecoresort_oop.nigar;

import javafx.beans.property.*;

    public class RoomOccupancy {
        private final StringProperty roomType;
        private final StringProperty date;
        private final IntegerProperty occupancyRate;

        public RoomOccupancy(String roomType, String date, int occupancyRate) {
            this.roomType = new SimpleStringProperty(roomType);
            this.date = new SimpleStringProperty(date);
            this.occupancyRate = new SimpleIntegerProperty(occupancyRate);
        }

        public StringProperty roomTypeProperty() {
            return roomType;
        }

        public StringProperty dateProperty() {
            return date;
        }

        public IntegerProperty occupancyRateProperty() {
            return occupancyRate;
        }
    }


