package inputoutputstreams;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleTextEditor {
    private final File fileToWrite;

    public ConsoleTextEditor(File fileToWrite) {
        this.fileToWrite = fileToWrite;
    }

    public void start() {
        List<String> allLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in); BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite))) {
            while (true) {
                String line = scanner.nextLine();
                if ("exit".equalsIgnoreCase(line.trim())) {
                    break;
                }
                writer.write(line);
                writer.newLine();
                allLines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        allLines.forEach(System.out::println);
    }

    public static void main(String[] args) {
        File file = new File("D:\\AdvJavaNotes\\zero_to_hero\\src\\inputoutputstreams\\console.txt");
        new ConsoleTextEditor(file).start();
    }
}