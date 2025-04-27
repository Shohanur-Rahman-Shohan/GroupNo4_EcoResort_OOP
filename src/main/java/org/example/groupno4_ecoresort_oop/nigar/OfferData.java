package org.example.groupno4_ecoresort_oop.nigar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OfferData {
    private final StringProperty packageName;
    private final StringProperty offerDetail;
    private final StringProperty roomType;
    private final StringProperty discount;

    public OfferData(String packageName, String offerDetail, String roomType, String discount) {
        this.packageName = new SimpleStringProperty(packageName);
        this.offerDetail = new SimpleStringProperty(offerDetail);
        this.roomType = new SimpleStringProperty(roomType);
        this.discount = new SimpleStringProperty(discount);
    }

    public StringProperty packageNameProperty() {
        return packageName;
    }

    public StringProperty offerDetailProperty() {
        return offerDetail;
    }

    public StringProperty roomTypeProperty() {
        return roomType;
    }

    public StringProperty discountProperty() {
        return discount;
    }
}
