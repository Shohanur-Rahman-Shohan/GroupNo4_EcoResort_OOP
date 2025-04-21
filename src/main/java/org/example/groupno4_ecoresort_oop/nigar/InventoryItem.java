package org.example.groupno4_ecoresort_oop.nigar;

    public class InventoryItem {
        private String name;
        private String stock;
        private String status;
        private String request;

        public InventoryItem(String name, String stock, String status, String request) {
            this.name = name;
            this.stock = stock;
            this.status = status;
            this.request = request;
        }

        public String getName() {
            return name;
        }

        public String getStock() {
            return stock;
        }

        public String getStatus() {
            return status;
        }

        public String getRequest() {
            return request;
        }
    }


