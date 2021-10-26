package maintask;

import java.io.*;
import java.util.Objects;

public class WorkWithFile {
    public static void countingFileValues(String filePath) {
        File file = new File(filePath);
        File directory = new File(file.getParent());
        File[] listFolders = directory.listFiles();
        int countFolders = 0, countFiles = 0, countFileLength = 0, countFilesInFolder = 0;
        assert listFolders != null;
        for (File files : listFolders) {
            if (files.isDirectory()) {
                countFolders++;
                for(File filesInFolder: Objects.requireNonNull(files.listFiles())){
                    countFilesInFolder++;
                }
            } else if (files.isFile()) {
                countFileLength += files.getName().length();
                countFiles++;
            }
        }
        System.out.println("Number of folders are: " + countFolders);
        System.out.println("Number of files are: " + countFiles);
        System.out.println("The average name's length of file is :" + countFileLength / countFiles);
        System.out.println("The average files in folders are: " + countFilesInFolder/ countFolders);

    }
}












