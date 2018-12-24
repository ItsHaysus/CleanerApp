package cleaningapp2.pkg0;

import Database.databasemain;
import Database.findFindExist;
import MVC.Controller;
import MVC.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * @author Jesus
 */
public class CleaningApp20 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //databasemain.downloadFiles();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        View root = new View();
        Controller controller = new Controller(root);

        Scene logScene = new Scene(root, 700, 400);
        String css = this.getClass().getResource("style.css").toExternalForm();
        logScene.getStylesheets().add(css);

        primaryStage.getIcons().add(new Image("file:icon.png"));
        primaryStage.setTitle("Computer Maintenance");
        primaryStage.setScene(logScene);
        primaryStage.show();
        primaryStage.sizeToScene();
        primaryStage.setOnCloseRequest((WindowEvent event1) -> {
            findFindExist.findAndDeleteBatchFiles();
        });
    }

}
