package maintask;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String argumentCommandLine : args) {
            stringBuilder.append(argumentCommandLine);
        }
        String path = stringBuilder.toString();
        File someFile = new File(path);
        if (someFile.isDirectory()) {
            WorkWithDirectory.recordingDirectoryStructure(path);
        } else if (someFile.isFile()) {
            WorkWithFile.countingFileValues(path);
        } else {
            System.out.println("Please enter the right path");

        }
    }
}




