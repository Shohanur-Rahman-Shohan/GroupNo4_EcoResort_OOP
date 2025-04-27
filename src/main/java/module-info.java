module org.example.groupno4_ecoresort_oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.groupno4_ecoresort_oop to javafx.fxml;
    exports org.example.groupno4_ecoresort_oop;
    exports org.example.groupno4_ecoresort_oop.shohan.controllers;
    opens org.example.groupno4_ecoresort_oop.shohan.controllers to javafx.fxml;
    exports org.example.groupno4_ecoresort_oop.user;
    opens org.example.groupno4_ecoresort_oop.user to javafx.fxml;
    exports org.example.groupno4_ecoresort_oop.arman.controller;
    opens org.example.groupno4_ecoresort_oop.arman.controller to javafx.fxml;
    exports org.example.groupno4_ecoresort_oop.arman;
    opens org.example.groupno4_ecoresort_oop.arman to javafx.fxml;
    exports org.example.groupno4_ecoresort_oop.Sadman;
    opens org.example.groupno4_ecoresort_oop.Sadman to javafx.fxml;


}