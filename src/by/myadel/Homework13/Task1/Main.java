package by.myadel.Homework13.Task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] arg) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        System.out.println("Результат:\n" + compressString(inputScanner.nextLine()));
    }

    private static String compressString(String text) {
        Pattern pattern = Pattern.compile("([a-zа-я])\\1+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "$1\\" + String.valueOf(matcher.end() - matcher.start()));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
