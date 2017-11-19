package by.myadel.Homework3.Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] inputArray = askIntArray();
        System.out.println("Исходный массив: ");
        printOutArray(inputArray);
        SortMethod[] sortMethods = new SortMethod[]{new BubbleSort(), new SelectionSort(), new InsertionSort()};
        for (SortMethod sortMethod : sortMethods) {
            outSortTimeAndSortedArray(sortMethod, inputArray);
        }
        System.out.print("| ");
        for (int i : inputArray) {
            if (i % 2 == 0) {
                System.out.print(i + " | ");
            }
        }
    }

    private static void outSortTimeAndSortedArray(SortMethod method, int[] inputArray) {
        SortResult sortResult = measureTimeOfSortArray(method, inputArray);
        System.out.println("Алгоритм сортировки: " + method.getName() + ". Время сортировки массива: " + sortResult.time + " ns");
        printOutArray(sortResult.sortedArray);
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

    private static SortResult measureTimeOfSortArray(SortMethod sortMethod, int[] array) {
        long startTime = System.nanoTime();
        int[] sortedArray = sortMethod.sort(array);
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        return new SortResult(time, sortedArray);
    }

    private static void printOutArray(int[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; ++i) {
            if (i < array.length - 1) {
                System.out.print(array[i] + " | ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.print(" ]\n");
    }
}
