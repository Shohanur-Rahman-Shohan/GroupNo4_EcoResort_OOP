package org.example.groupno4_ecoresort_oop.arman;

import java.io.Serializable;

public class Complaint implements Serializable {
        private String id;
        private String description;
        private String type;
        private String status;

        public Complaint(String id, String description, String type, String status) {
            this.id = id;
            this.description = description;
            this.type = type;
            this.status = status;
        }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Complaint{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

