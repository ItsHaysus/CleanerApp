package MVC;

import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.awt.Desktop.getDesktop;

/**
 * @author Jesus
 */
public class Methods {

    String filePath = new File("").getAbsolutePath();
    Stage logInStage = new Stage();
    Stage CirculationStage = new Stage();
    popUps pops = new popUps();
    View view = new View();

    void backupFiles() {
        String Backupcommand = "cmd /c start " + filePath.concat("\\Batchfiles\\backup.bat");
        try {
            Runtime.getRuntime().exec(Backupcommand);
        } catch (IOException ex) {
            pops.outputText(ex.toString());
        }
    }

    void cleanOldFiles(String output) throws IOException {
        String command = "\\Batchfiles\\Deleteoldfiles.bat";
        String runcommand = "cmd /c start " + filePath.concat(command);
        try {
            Runtime.getRuntime().exec(runcommand);
        } catch (IOException ex) {
            pops.outputText(ex.toString());
        }
    }

    void cleanWithCCleaner(String output) throws IOException {
        String command = "\\Dependencies\\ccleaner /auto";
        String runcommand = "cmd /c start " + filePath.concat(command);
        try {
            Runtime.getRuntime().exec(runcommand);
        } catch (IOException ex) {
            pops.outputText(ex.toString());
        }
    }

    void defragDisk(String output) throws IOException {
        String command = "\\Batchfiles\\defrag.bat";
        String runcommand = "cmd /c start " + filePath.concat(command);
        try {
            Runtime.getRuntime().exec(runcommand);
        } catch (IOException ex) {
            pops.outputText(ex.toString());
        }
    }

    void cleanTempFiles(String output) throws IOException {
        String runcommand = "cmd /c start Cleanmgr /sagerun:1";
        try {
            Runtime.getRuntime().exec(runcommand);
        } catch (IOException ex) {
            pops.outputText(ex.toString());
        }
    }

    void Help() {
        try {
            String findHelp = filePath.concat("\\Webcontent\\read.pdf");
            File file = new File(findHelp);
            if (file.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                } else {
                    pops.notSupported();
                }
            }

        } catch (IOException ex) {
        }
    }

    void Feedback() {
        //TODO make email use java mail instead

        Desktop desktop = getDesktop();
        String feedback = "mailto:jesus.a.sanchez01@utrgv.edu?cc=ezequiel.melgoza@utrgv.edu&subject=Feedback";
        URI uri = URI.create(feedback);
        try {
            desktop.mail(uri);
        } catch (IOException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void changeToCirculation() {
        view.updateToCirculation();
    }

    void changeToStaff() {
        pops.notSupported();
    }

    void about() {
        pops.About();
    }

    void ScheduleTask() {
        String file = filePath.concat("\\Batchfiles\\backup.bat");
        String ScheduleTask = "SchTasks /Create /SC MONTHLY /D 1 /TN “Backup” /TR “" + file + "” /ST 16:30";
        Process child;
        try {
            child = Runtime.getRuntime().exec(ScheduleTask);
            pops.Success();
        } catch (IOException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
