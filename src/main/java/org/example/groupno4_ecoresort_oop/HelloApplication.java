package org.example.groupno4_ecoresort_oop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.groupno4_ecoresort_oop.shohan.managers.Managers;
import org.example.groupno4_ecoresort_oop.user.User;
import org.example.groupno4_ecoresort_oop.utils.BinaryFileHelper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneSwitcher.stage = stage;



        // File location
        File file = new File("Data/arman/users.bin");


//        // Delete previous data if the file exists
//        if (file.exists()) {
//            file.delete();
//        }



        // Add default managers (........)
        Managers.addDefaultManagers();





        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("user/LoginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ECO Resort");
        stage.setScene(scene);
        stage.show();




        // Print current user data from the binary file
        List<User> users = BinaryFileHelper.readAllObjects(file);
        System.out.println("======= Loaded Users from users.bin =======");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("===========================================");
    }



    public static void main(String[] args) {
        launch();
    }
}
