package by.myadel.Homework13.Task2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Введите название файла: ");
        try {
            System.out.println("Результат:\n" + getFormat(inputScanner.nextLine()));
        } catch (InvalidFileName invalidFileName) {
            System.out.println("Имя файла введено неверно.");
        }
    }

    private static String getFormat(String text) throws InvalidFileName {
        Pattern pattern = Pattern.compile("\\.(\\w+)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new InvalidFileName();
    }

}
