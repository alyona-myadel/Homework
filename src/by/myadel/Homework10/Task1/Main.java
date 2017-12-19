package by.myadel.Homework10.Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        System.out.println("Введите 1 - для ввода строки; \nВведите 0 - для окончания ввода.");
        Scanner inputScanner = new Scanner(System.in);
        int input = 1;
        while (input == 1) {
            input = inputScanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Введите строку: ");
                    String string = inputScanner.next();
                    stringArrayList.add(string);
                    System.out.println("Введите 1 - для ввода строки; \nВведите 0 - для окончания ввода.");
                    break;
                case 0:
                    break;
            }
        }
        ArrayList<String> convertArrayListString = getArrayWithoutDuplicates(stringArrayList);
        System.out.println("\nИсходный массив: ");
        printArrayList(stringArrayList);
        System.out.println("\nРезультат: ");
        printArrayList(convertArrayListString);
    }

    private static ArrayList<String> getArrayWithoutCharacter(ArrayList<String> inputArrayListString) {
        ArrayList<String> arrayListString = new ArrayList<>();
        for (String string : inputArrayListString) {
            arrayListString.add(string.replace("a", ""));
        }
        return arrayListString;
    }

    private static void printArrayList(ArrayList<String> arrayList) {
        for (String string : arrayList) {
            System.out.print(string + " ");
        }
    }

    private static ArrayList<String> getArrayWithoutDuplicates(ArrayList<String> inputArrayListString) {
        ArrayList<String> arrayListString = new ArrayList<>();
        Map<String, Integer> doubles = new HashMap<>();
        for (String string : inputArrayListString) {
            if (doubles.containsKey(string)) {
                doubles.put(string, doubles.get(string) + 1);
            } else {
                doubles.put(string, 1);
            }
        }
        arrayListString.addAll(doubles.keySet());
        return arrayListString;
    }
}