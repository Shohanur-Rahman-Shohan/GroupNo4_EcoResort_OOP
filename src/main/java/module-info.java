module org.example.groupno4_ecoresort_oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.groupno4_ecoresort_oop to javafx.fxml;
    exports org.example.groupno4_ecoresort_oop;
    exports org.example.groupno4_ecoresort_oop.shohan.controllers;
    opens org.example.groupno4_ecoresort_oop.shohan.controllers to javafx.fxml;
    exports org.example.groupno4_ecoresort_oop.user;
    opens org.example.groupno4_ecoresort_oop.user to javafx.fxml;
}