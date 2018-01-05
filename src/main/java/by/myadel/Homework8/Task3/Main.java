package by.myadel.Homework8.Task3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("C:\\Users\\alena\\IdeaProjects\\test1.txt", true)) {
            Scanner inputScanner = new Scanner(System.in);
            String text = inputScanner.nextLine();
            writer.append("\n");
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileReader reader = new FileReader("C:\\Users\\alena\\IdeaProjects\\test1.txt")) {
            int value;
            while ((value = reader.read()) != -1) {
                System.out.print((char) value);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}