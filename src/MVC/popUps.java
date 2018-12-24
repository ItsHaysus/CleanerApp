package MVC;

import java.awt.Desktop;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.scene.control.TextArea;
import mailService.MailMain;

/**
 * @author Jesus
 */
public class popUps {

    Stage primaryStage = null;

    void CCleanerSuccessful() {

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        BorderPane dialogVbox = new BorderPane();
        Text popupText = new Text("CCleaner started sucessfully \nStarting Cleanup");
        popupText.setId("popuptext");
        dialogVbox.setCenter(popupText);
        dialogVbox.setId("popupbox");
        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        dialog.setScene(dialogScene);
        dialog.setTitle("Success!");
        dialog.getIcons().add(new Image("file:icon.png"));
        dialog.centerOnScreen();
        dialog.show();
    }

    void notSupported() {

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        BorderPane dialogVbox = new BorderPane();
        Text popupText = new Text("Feature not yet supported");
        popupText.setId("popuptext");
        dialogVbox.setCenter(popupText);
        dialogVbox.setId("popupbox");
        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        dialog.setScene(dialogScene);
        dialog.setTitle("Not yet!");
        dialog.getIcons().add(new Image("file:icon.png"));
        dialog.centerOnScreen();
        dialog.show();
    }

    void Success() {

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        BorderPane dialogVbox = new BorderPane();
        Text popupText = new Text("Task was created!");
        popupText.setId("popuptext");
        dialogVbox.setCenter(popupText);
        dialogVbox.setId("popupbox");
        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        dialog.setScene(dialogScene);
        dialog.setTitle("Success");
        dialog.getIcons().add(new Image("file:icon.png"));
        dialog.centerOnScreen();
        dialog.show();
    }

    public void outputText(String output) {

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        BorderPane dialogVbox = new BorderPane();
        Text popupText = new Text(output);
        popupText.setId("popuptext");
        dialogVbox.setCenter(popupText);
        dialogVbox.setId("popupbox");
        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        dialog.setScene(dialogScene);
        dialog.setTitle("Success");
        dialog.getIcons().add(new Image("file:icon.png"));
        dialog.centerOnScreen();
        dialog.show();
    }

    void About() {

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        BorderPane dialogVbox = new BorderPane();
        GridPane about = new GridPane();

        Text popupText = new Text("Current version is 2.1.0");
        popupText.setId("popuptext");

        Hyperlink link = new Hyperlink();
        link.setText("Download the latest version here");
        link.setOnAction((ActionEvent e) -> {
            try {
                Desktop.getDesktop().browse(new URI("https://itshaysus.github.io/Cleaningapp/"));
            } catch (IOException | URISyntaxException e1) {
            }
        });
        about.setAlignment(Pos.CENTER);

        about.add(popupText,
                0, 0);
        about.add(link,
                0, 1);

        dialogVbox.setCenter(about);

        dialogVbox.setId("popupbox");
        Scene dialogScene = new Scene(dialogVbox, 200, 100);

        dialog.setScene(dialogScene);

        dialog.setTitle("About");
        dialog.getIcons().add(new Image("file:icon.png"));
        dialog.centerOnScreen();

        dialog.show();
    }

    public void mailPop() {
        TextField email = new TextField();
        TextField subject = new TextField();
        TextArea body = new TextArea();
        Label emailLabel = new Label("Enter your email: ");
        Label SubjectLabel = new Label("Enter your subject: ");
        Label bodyLabel = new Label("Enter your messege: ");
        GridPane grid = new GridPane();
        Button button = new Button("Send");
        grid.add(emailLabel, 0, 0);
        grid.add(email, 1, 0);
        grid.add(SubjectLabel, 0, 1);
        grid.add(subject, 1, 1);
        grid.add(bodyLabel, 0, 2);
        grid.add(body, 1, 2);
        grid.add(button, 1, 3);

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);

        BorderPane dialogVbox = new BorderPane();
        BorderPane.setAlignment(grid, Pos.CENTER);
        dialogVbox.setCenter(grid);
        dialogVbox.setId("popupbox");
        Scene dialogScene = new Scene(dialogVbox, 600, 500);
        dialog.setScene(dialogScene);
        dialog.setTitle("Success");
        dialog.getIcons().add(new Image("file:icon.png"));
        dialog.centerOnScreen();
        dialog.show();
        button.setOnAction((event) -> {
            String bodyText = body.getText();
            String customereMail = email.getText();
            String subject1 = subject.getText();

            MailMain mail = new MailMain();
            mail.sendMail(bodyText, customereMail, subject1);
            dialog.close();
        });
    }
}
