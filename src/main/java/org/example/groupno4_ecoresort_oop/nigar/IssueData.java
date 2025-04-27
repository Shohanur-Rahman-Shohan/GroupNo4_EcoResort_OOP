package org.example.groupno4_ecoresort_oop.nigar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class IssueData {
    private final StringProperty issue;
    private final StringProperty status;

    public IssueData(String issue, String status) {
        this.issue = new SimpleStringProperty(issue);
        this.status = new SimpleStringProperty(status);
    }

    public StringProperty issueProperty() {
        return issue;
    }

    public StringProperty statusProperty() {
        return status;
    }
}
