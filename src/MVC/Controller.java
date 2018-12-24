/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import javafx.beans.value.ObservableValue;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jesus
 * @version 2.1.0
 */
public class Controller {

    View view;
    Methods methods = new Methods();
    popUps pops = new popUps();
    String output = "";

    public Controller(View view) {
        this.view = view;
        setMethods();
    }

    void setMethods() {
        view.logInOptions.getSelectionModel().selectedItemProperty().addListener((ObservableValue ov, Object t, Object t1) -> {
            view.Login.setOnAction((event) -> {
                switch (t1.toString()) {
                    case "Circulation":
                        view.updateToCirculation();
                        break;
                    case "Staff":
                        pops.notSupported();
                        break;
                }
            });
        });
        view.BakcupFiles.setOnAction((event)
                -> {
            methods.backupFiles();
        });
        view.CleanOldFiles.setOnAction((event)
                -> {
            try {
                methods.cleanOldFiles(output);
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        view.CleanOldfilesWithCCleaner.setOnAction((event)
                -> {
            try {
                methods.cleanWithCCleaner(output);
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        view.CleanTempfiles.setOnAction((event)
                -> {
            try {
                methods.cleanTempFiles(output);
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        view.DefragDisk.setOnAction((event)
                -> {
            try {
                methods.defragDisk(output);

            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        view.about.setOnAction((event)
                -> {
            methods.about();
        });
        view.feedback.setOnAction((event)
                -> {
            pops.mailPop();
        });
        view.help.setOnAction((event)
                -> {
            methods.Help();
        });
        view.backup.setOnAction((event)
                -> {
            methods.ScheduleTask();
        });

    }

}
