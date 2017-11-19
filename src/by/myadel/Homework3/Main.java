package by.myadel.Homework3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] inputArray = askIntArray();
        System.out.println("Исходный массив: ");
        printOutArray(inputArray);
        printArraySortedByBubble(inputArray);
        printArraySortedByInsertion(inputArray);
        printArraySortedBySelection(inputArray);
    }

    private static void printArraySortedByBubble(int[] inputArray) {
        SortMethod method = new BubbleSort();
        long time = measureTimeOfSortArray(method, inputArray);
        System.out.println("Время сортировки массива пузырьком: " + time + " ns");
        System.out.println(Arrays.toString(method.sort(inputArray)));
    }

    private static void printArraySortedByInsertion(int[] inputArray) {
        SortMethod method = new InsertionSort();
        long time = measureTimeOfSortArray(method, inputArray);
        System.out.println("Время сортировки массива вставками: " + time + " ns");
        System.out.println(Arrays.toString(method.sort(inputArray)));
    }

    private static void printArraySortedBySelection(int[] inputArray) {
        SortMethod method = new SelectionSort();
        long time = measureTimeOfSortArray(method, inputArray);
        System.out.println("Время сортировки массива выбором: " + time + " ns");
        System.out.println(Arrays.toString(method.sort(inputArray)));
    }

    private static int askArraySize() {
        System.out.println("Введите размер массива: ");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }

    private static int[] askIntArray() {
        int size = askArraySize();
        if (size <= 0) {
            return new int[]{};
        }
        int array[] = new int[size];
        Scanner inputScanner = new Scanner(System.in);
        for (int i = 0; i < size; ++i) {
            System.out.println("Введите целое число в массив (index = " + i + "):");
            int valueArray = inputScanner.nextInt();
            array[i] = valueArray;
        }
        return array;
    }

    private static long measureTimeOfSortArray(SortMethod sortMethod, int[] array) {
        long startTime = System.nanoTime();
        sortMethod.sort(array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static void printOutArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; ++i) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.print("]\n");
    }

}
