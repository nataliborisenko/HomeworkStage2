package maintask;

import java.io.*;
import java.util.Objects;

public class WorkWithDirectory {
    public static void recordingDirectoryStructure(String directoryPath) {
        File directory = new File(directoryPath);
        File fileForRecording = new File("./src/maintask/structure.txt");
        try {
            if (!fileForRecording.createNewFile()) {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter(fileForRecording)) {
            fileWriter.write(directory.getName() + System.lineSeparator());
            for (File folder : Objects.requireNonNull(directory.listFiles())) {
                fileWriter.write("-- " + folder.getName() + System.lineSeparator());
                int count = 1;
                for (File files : Objects.requireNonNull(folder.listFiles())) {
                    if (files.isFile()) {
                        fileWriter.write("    " + count + " - " + files.getName() + System.lineSeparator());
                        count++;
                    } else if (files.isDirectory()) {
                        fileWriter.write("-----" + files.getName() + System.lineSeparator());
                        for (File someFile : Objects.requireNonNull(files.listFiles())) {
                            if (someFile.isFile()) {
                                fileWriter.write("         - " + someFile.getName() + System.lineSeparator());
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



