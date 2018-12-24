package Database;

import java.io.*;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

public class findFindExist {

    public static void findAndDeleteBatchFiles() {
        File index = new File(System.getProperty("user.dir") + "\\Batchfiles\\");
        File[] files = index.listFiles();
        if (files != null) { //some JVMs return null for empty dirs
            for (File f : files) {
                if (f.isDirectory()) {
                    findAndDeleteBatchFiles();
                } else {
                    f.delete();
                }
            }
        }
        index.delete();
    }

    void findIfFilesExist(List<String> listOfFiles) {
        //find if certain files exist to make sure theyre always up to date
        List<String> filesDownlaodedAlready = new LinkedList<>();
        for (int i = 0; i < listOfFiles.size(); i++) {
            File f = new File(listOfFiles.get(i));
            if (f.exists()) {
                filesDownlaodedAlready.add(listOfFiles.get(i));
            }
        }
        for (int i = 0; i < filesDownlaodedAlready.size(); i++) {
            listOfFiles.remove(filesDownlaodedAlready.get(i));
        }
    }

    void findFilesExist(List<String> listOfFiles) {
        File file = new File(System.getProperty("user.dir"));
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File content : contents) {
                for (int j = 0; j < listOfFiles.size(); j++) {
                    if (CollectionUtils.containsAny(listOfFiles, contents)) {
                        listOfFiles.remove(j);
                    }
                }
            }
        }
    }
}
