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
    public static Stage getPrimaryStage() {
        return null;
    }

    @Override
    public void start(Stage stage) throws IOException {
        SceneSwitcher.stage = stage;



        // File location
        File file = new File("Data/users.bin");
        File guestFile = new File("Data/guests.bin");
        File allUserFile= new File("Data/allTypeUsers.bin");


//        // Delete previous data if the file exists
//        if (file.exists()) {
//            file.delete();
//        }
//        if (guestFile.exists()) {
//            guestFile.delete();
//        }
//        if (allUserFile.exists()) {
//            allUserFile.delete();
//        }




        // Add default managers (........)
        Managers.addDefaultManagers();

        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("arman/MTDashboard.fxml"));   // Main

//                HelloApplication.class.getResource("shohan/controllers/appointUser.fxml"));  // Temporary (Delete Afterward)


        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ECO Resort");
        stage.setScene(scene);
        stage.show();





        List<User> users = BinaryFileHelper.readAllObjects(allUserFile);
        System.out.println("======= Loaded Users from allUserFile.bin =======");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("===========================================");
    }








    public static void main(String[] args) {
        launch();
    }
}
