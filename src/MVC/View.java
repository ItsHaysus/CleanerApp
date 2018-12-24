package MVC;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * @author Jesus
 */
public class View extends BorderPane {

    //create menus
    Menu helpMenu = new Menu("Menu");
    MenuItem about = new MenuItem("About");
    MenuItem help = new MenuItem("Help");
    MenuItem feedback = new MenuItem("Feedback");
    MenuItem backup = new MenuItem("Schedule backup task");

    //create buttons
    Button BakcupFiles = new Button("Backup Files");
    Button CleanOldFiles = new Button("Delete Old Files");
    Button CleanOldfilesWithCCleaner = new Button("Clean Using CCleaner");
    Button DefragDisk = new Button("Defragment Disk");
    Button CleanTempfiles = new Button("Clean Using Disk Cleanup");
    Button Login = new Button("Login");
    //add Combobox
    ObservableList<String> profiles
            = FXCollections.observableArrayList(
            "Circulation",
            "Staff"
    );
    ComboBox logInOptions = new ComboBox(profiles);

    public View() {
        this.setTop(menuBar());
        this.setCenter(Loginui());
    }

    public ComboBox getLogInOptions() {
        return logInOptions;
    }

    public void setLogInOptions(ComboBox logInOptions) {
        this.logInOptions = logInOptions;
    }

    public void updateToCirculation() {
        this.setCenter(null);
        this.setCenter(ui());
        this.setBottom(buttonPane());

    }

    public void updateToLogin() {
        this.getChildren().clear();
        this.setCenter(Loginui());
    }

    private GridPane buttonPane() {
        GridPane ButtonPane = new GridPane();
        ButtonPane.setPadding(new Insets(25, 25, 25, 25));
        ButtonPane.setHgap(10);
        ButtonPane.setVgap(10);
        ButtonPane.setAlignment(Pos.CENTER);
        ButtonPane.add(BakcupFiles, 0, 0);
        ButtonPane.add(CleanOldfilesWithCCleaner, 1, 0);
        ButtonPane.add(CleanOldFiles, 2, 0);
        ButtonPane.add(CleanTempfiles, 3, 0);
        ButtonPane.add(DefragDisk, 4, 0);
        return ButtonPane;

    }

    public BorderPane ui() {
        BorderPane UI = new BorderPane();
        BorderPane.setAlignment(UI, Pos.CENTER);
        UI.setTop(bannerPane());
        UI.setCenter(README());

        return UI;
    }

    private MenuBar menuBar() {
        helpMenu.getItems().addAll(help, about, feedback, backup);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(helpMenu);
        return menuBar;
    }

    private BorderPane Loginui() {
        BorderPane loginUI = new BorderPane();
        loginUI.setTop(bannerPane());
        loginUI.setCenter(logInButtonPane());
        return loginUI;
    }

    private GridPane logInButtonPane() {
        GridPane loginbuttonpane = new GridPane();
        loginbuttonpane.setAlignment(Pos.CENTER);
        loginbuttonpane.setVgap(10);
        loginbuttonpane.setHgap(10);

        loginbuttonpane.add(logInOptions, 0, 1);
        final Label notification = new Label("Choose a profile: ");
        loginbuttonpane.add(notification, 0, 0);
        loginbuttonpane.add(Login, 1, 1);

        return loginbuttonpane;
    }

    public Text README() {
        Text readme = new Text();
        readme.setText("Please select an option:"
                + "\nBackup files: backs up files with the supported extentions."
                + "\nClean using CCleaner: Runs CCleaner in auto mode."
                + "\nDelete old files: Deletes files with the supported extentions and older than 365 days."
                + "\nClean using Disk Cleaup: Uses Disk Cleanup to run the default Window's clean utility."
                + "\nDegragment disk: Defragments C: drive. Requires administrator rights and takes hours.");

        return readme;
    }

    private Text Title() {
        Text title = new Text("Cleaning Tool");
        title.setId("titleBanner");
        return title;
    }

    private StackPane bannerPane() {
        StackPane bannerPane = new StackPane();
        bannerPane.setAlignment(Pos.CENTER);
        bannerPane.getChildren().add(Title());

        return bannerPane;
    }

    public Menu getHelpMenu() {
        return helpMenu;
    }

    public void setHelpMenu(Menu helpMenu) {
        this.helpMenu = helpMenu;
    }

    public MenuItem getAbout() {
        return about;
    }

    public void setAbout(MenuItem about) {
        this.about = about;
    }

    public MenuItem getHelp() {
        return help;
    }

    public void setHelp(MenuItem help) {
        this.help = help;
    }

    public MenuItem getFeedback() {
        return feedback;
    }

    public void setFeedback(MenuItem feedback) {
        this.feedback = feedback;
    }

    public Button getBakcupFiles() {
        return BakcupFiles;
    }

    public void setBakcupFiles(Button BakcupFiles) {
        this.BakcupFiles = BakcupFiles;
    }

    public Button getCleanOldFiles() {
        return CleanOldFiles;
    }

    public void setCleanOldFiles(Button CleanOldFiles) {
        this.CleanOldFiles = CleanOldFiles;
    }

    public Button getCleanOldfilesWithCCleaner() {
        return CleanOldfilesWithCCleaner;
    }

    public void setCleanOldfilesWithCCleaner(Button CleanOldfilesWithCCleaner) {
        this.CleanOldfilesWithCCleaner = CleanOldfilesWithCCleaner;
    }

    public Button getDefragDisk() {
        return DefragDisk;
    }

    public void setDefragDisk(Button DefragDisk) {
        this.DefragDisk = DefragDisk;
    }

    public Button getCleanTempfiles() {
        return CleanTempfiles;
    }

    public void setCleanTempfiles(Button CleanTempfiles) {
        this.CleanTempfiles = CleanTempfiles;
    }

    public ObservableList<String> getProfiles() {
        return profiles;
    }

    public void setProfiles(ObservableList<String> profiles) {
        this.profiles = profiles;
    }
}
