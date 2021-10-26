package optionaltask.task3;

import java.io.*;

public class RecordingChars {
    public static void main(String[] args) {


        File directory = new File("./src/optionaltask/task3/directory");
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
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = new StringBuilder(line).reverse().toString().split(" ");
                StringBuilder stringbuilder = new StringBuilder();
                for (int i = words.length - 1; i >= 0; i--)
                stringbuilder.append(words[i]).append(" ");
                writer.write(stringbuilder + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
