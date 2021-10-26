package optionaltask.task1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class RecordRandomNumbers {
    public static void main(String[] args) {
        File directory = new File("./src/optionaltask/task1/directory");
        File file = new File(directory, "/fileForTask1.txt");
        try {
            directory.mkdir();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            Random randomNumbers = new Random();
            for (int i = 0; i < 15; i++) {
                fileWriter.write(randomNumbers.nextInt(100) + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             FileWriter writer = new FileWriter(file, true)) {
            ArrayList<Integer> arrayInt = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                arrayInt.add((Integer.valueOf(line)));
            }
            List<Integer> sortedArray = arrayInt.stream()
                    .sorted()
                    .collect(Collectors.toList());
            for (Integer integer : sortedArray) {
                writer.write(integer + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

















