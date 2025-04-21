package org.example.groupno4_ecoresort_oop.nigar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Campaign {

    private final StringProperty campaignName;
    private final StringProperty category;
    private final StringProperty status;
    private final StringProperty budget;
    private final StringProperty date;
    private final StringProperty description;

    public Campaign(String campaignName, String category, String status, String budget, String date, String description) {
        this.campaignName = new SimpleStringProperty(campaignName);
        this.category = new SimpleStringProperty(category);
        this.status = new SimpleStringProperty(status);
        this.budget = new SimpleStringProperty(budget);
        this.date = new SimpleStringProperty(date);
        this.description = new SimpleStringProperty(description);
    }

    public StringProperty campaignNameProperty() {
        return campaignName;
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public StringProperty budgetProperty() {
        return budget;
    }

    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty descriptionProperty() {
        return description;
    }
}
