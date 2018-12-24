/*
 * Copyright 2018 jesus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Database;

import java.io.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jesus
 */
public class databasemain {

    public static void downloadFiles() throws FileNotFoundException, IOException {
        Statement stmt = null;
        Connection conn = null;
        InputStream input = null;
        FileOutputStream output = null;
        ResultSet result = null;
        List<String> fileNamesForBatfiles = new LinkedList<>();
        List<Blob> BatchFileList = new LinkedList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databatchfile_13", "jesus_13", "12qwaszx");
            if (conn.isValid(5)) {
                System.out.println("Connected to database!");
            }

            stmt = conn.createStatement();
            String sql = "select * from batchfiles";
            result = stmt.executeQuery(sql);

            //get names from database
            while (result.next()) {
                fileNamesForBatfiles.add(result.getString(2));

                for (int i = 0; i < fileNamesForBatfiles.size(); i++) {
                    System.out.println(fileNamesForBatfiles.get(i));
                }
                findFindExist find = new findFindExist();
                find.findIfFilesExist(fileNamesForBatfiles); //will check if the files existm and if not then redownload them

                //get files from database
                BatchFileList.add(result.getBlob(3));
                for (int i = 0; i < fileNamesForBatfiles.size(); i++) {

                    input = BatchFileList.get(i).getBinaryStream();
                    boolean createBatchfileDirectory = (new File(".\\Batchfiles\\")).mkdirs();
                    boolean createCssDirectory = (new File(".\\Webcontent\\")).mkdirs();
                    boolean createExeDirectory = (new File(".\\Dependencies\\")).mkdirs();
                    if (fileNamesForBatfiles.get(i).endsWith(".css") || fileNamesForBatfiles.get(i).endsWith(".pdf")) {
                        if (!createCssDirectory) {
                            output = new FileOutputStream(".\\Webcontent\\" + fileNamesForBatfiles.get(i));
                            byte[] buffer = new byte[4096];
                            int lenght = 0;

                            while ((lenght = input.read(buffer)) != -1) {
                                output.write(buffer, 0, lenght);
                            }
                        }
                    }
                    if (fileNamesForBatfiles.get(i).endsWith(".bat")) {
                        if (!createBatchfileDirectory) {
                            output = new FileOutputStream(".\\Batchfiles\\" + fileNamesForBatfiles.get(i));
                            byte[] buffer = new byte[4096];
                            int lenght = 0;

                            while ((lenght = input.read(buffer)) != -1) {
                                output.write(buffer, 0, lenght);
                            }
                        }

                    }
                    if (fileNamesForBatfiles.get(i).endsWith(".png")) {
                        if (!createBatchfileDirectory) {
                            output = new FileOutputStream(fileNamesForBatfiles.get(i));
                            byte[] buffer = new byte[15000];
                            int lenght = 0;

                            while ((lenght = input.read(buffer)) != -1) {
                                output.write(buffer, 0, lenght);
                            }
                        }

                    }
                    if (fileNamesForBatfiles.get(i).endsWith(".exe")) {
                        if (!createExeDirectory) {
                            output = new FileOutputStream(".\\Dependencies\\" + fileNamesForBatfiles.get(i));
                            byte[] buffer = new byte[4096];
                            int lenght = 0;

                            while ((lenght = input.read(buffer)) != -1) {
                                output.write(buffer, 0, lenght);
                            }
                        }

                    }
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
