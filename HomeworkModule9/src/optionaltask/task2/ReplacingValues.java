package optionaltask.task2;

import java.io.*;

public class ReplacingValues {
    public static void main(String[] args) {
        File directory = new File("./src/optionaltask/task2/directory");
        File fileForRecording = new File(directory, "/fileForRecording.txt");
        File fileForReading = new File(directory, "/fileForReading.txt");

        try {
            directory.mkdir();
            fileForRecording.createNewFile();
            fileForReading.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileForReading));
             FileWriter writer = new FileWriter(fileForRecording)) {
            String line, resultString;
            while ((line = reader.readLine()) != null) {
                resultString = line;
                if (line.contains("public")) {
                    resultString = line.replace("public", "private");
                }
                 writer.write(resultString + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}









//        try (FileReader reader = new FileReader(fileForReading);
//             FileWriter writer = new FileWriter(fileForRecording)) {
//            StringBuilder temporarilyString = new StringBuilder();
//            String resultString;
//            char[] buffer = new char[3];
//            int count = reader.read(buffer);
//            while (count > 0) {
//                resultString = (temporarilyString.append(new String(buffer))).toString();
//                if (resultString.contains("public")) {
//                    resultString = (resultString.replace("public", "private"));
//                }
//                writer.write(resultString);
//                count = reader.read(buffer);
//            }
//        } catch (IOException ioException) {
//            ioException.printStackTrace();


// bufferReader / scanner