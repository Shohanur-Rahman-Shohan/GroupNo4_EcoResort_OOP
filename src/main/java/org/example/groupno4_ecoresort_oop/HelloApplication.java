package org.example.groupno4_ecoresort_oop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.shohan.managers.Manager;
import org.example.groupno4_ecoresort_oop.shohan.managers.GeneralManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

//        ArrayList<Manager> managers= new ArrayList<>();
//        Manager GM= new GeneralManager(2312227, "Shohanur", "Rahman", "shohanur@gmail.com", "12345", "+8801xxxxxxxxx");
//        managers.add(GM);


        // Only One GM but FM can be two or three
        // GM can appoint or remove FM

        List<Manager> gmLst = new ArrayList<>(List.of(new GeneralManager(11111, "Shohanur", "Rahman", "generalmanager@gmail.com", "12345", "+8801xxxxxxxxx")));
        List<Manager> fmLst = new ArrayList<>();
        fmLst.add(new GeneralManager(22222, "Shohanur", "Rahman", "financemanager@gmail.com", "12345", "+8801xxxxxxxxx"));







        SceneSwitcher.stage= stage;
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("arman/ACDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ECO Resort");
        stage.setScene(scene);



        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}