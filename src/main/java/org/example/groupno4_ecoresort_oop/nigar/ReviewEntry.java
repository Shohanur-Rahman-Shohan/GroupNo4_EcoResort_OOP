package org.example.groupno4_ecoresort_oop.nigar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;

public class ReviewEntry {

    private StringProperty guestName;
    private StringProperty review;
    private IntegerProperty rating;
    private StringProperty reply;
    private StringProperty date;

    public ReviewEntry(String guestName, String review, int rating, String reply, String date) {
        this.guestName = new SimpleStringProperty(guestName);
        this.review = new SimpleStringProperty(review);
        this.rating = new SimpleIntegerProperty(rating);
        this.reply = new SimpleStringProperty(reply);
        this.date = new SimpleStringProperty(date);
    }


    public String getGuestName() {
        return guestName.get();
    }

    public StringProperty guestNameProperty() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName.set(guestName);
    }

    public String getReview() {
        return review.get();
    }

    public StringProperty reviewProperty() {
        return review;
    }

    public void setReview(String review) {
        this.review.set(review);
    }

    public int getRating() {
        return rating.get();
    }

    public IntegerProperty ratingProperty() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating.set(rating);
    }

    public String getReply() {
        return reply.get();
    }

    public StringProperty replyProperty() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply.set(reply);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
