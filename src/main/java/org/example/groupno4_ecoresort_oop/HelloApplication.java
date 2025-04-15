package org.example.groupno4_ecoresort_oop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.arman.ActivityCoordinator;
import org.example.groupno4_ecoresort_oop.shohan.managers.Manager;
import org.example.groupno4_ecoresort_oop.shohan.managers.GeneralManager;

import java.io.IOException;
import java.util.ArrayList;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        ArrayList<Manager> managers= new ArrayList<>();
        Manager GM= new GeneralManager(2312227, "Shohanur", "Rahman", "shohanur@gmail.com", "12345", "+8801xxxxxxxxx");
        managers.add(GM);

        SceneSwitcher.stage= stage;
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("user/LoginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ECO Resort");
        stage.setScene(scene);



        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}