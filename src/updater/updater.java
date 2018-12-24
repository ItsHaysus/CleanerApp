package updater;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @author Jesus
 */
public class updater extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        update();
        if (update()) {
            popup("Update Successful!\nPlease relaunch the application");
        }
    }

    private void popup(String messge) {
        Stage primaryStage = new Stage();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        BorderPane dialogVbox = new BorderPane();
        Text text = new Text(messge);
        text.setFontSmoothingType(FontSmoothingType.LCD);
        text.setFont(Font.font(15));
        dialogVbox.setCenter(text);
        Scene dialogScene = new Scene(dialogVbox, 200, 150);
        dialog.setScene(dialogScene);
        dialog.setTitle("Updater");
        dialog.show();

    }

    private boolean update() {
        String filePath = new File("").getAbsolutePath();
        String s = filePath.concat("\\Cleaning Tool.exe");
        Path movefrom = FileSystems.getDefault().getPath(s);
        Path target = FileSystems.getDefault().getPath("C:\\CleaningTool\\Cleaning Tool.exe");
        Path target_dir = FileSystems.getDefault().getPath("C:\\CleaningTool");
        try {
            Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            popup("Error while updating: \n" + e.getMessage());
            return false;
        }
    }
}
