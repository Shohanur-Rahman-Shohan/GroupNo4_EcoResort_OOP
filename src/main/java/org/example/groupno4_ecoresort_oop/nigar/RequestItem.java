package org.example.groupno4_ecoresort_oop.nigar;

public class RequestItem {
    private String date;
    private String priority;
    private String request;

    public RequestItem(String date, String priority, String request) {
        this.date = date;
        this.priority = priority;
        this.request = request;
    }

    public String getDate() {
        return date;
    }

    public String getPriority() {
        return priority;
    }

    public String getRequest() {
        return request;
    }
}
