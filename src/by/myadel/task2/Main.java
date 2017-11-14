package by.myadel.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        task1();
        task3();
    }

    private static void task1() {
        System.out.println("Task 1: \nВведите размер массива: ");
        Scanner inputScanner = new Scanner(System.in);
        int size = inputScanner.nextInt();
        if (size <= 0) {
            System.out.println("Error");
            return;
        }
        int array[] = new int[size];
        for (int i = 0; i < size; ++i) {
            System.out.println("Введите целое число в массив (index = " + i + "):");
            int valueArray = inputScanner.nextInt();
            array[i] = valueArray;
        }
        int minValue = array[0];
        int minIndex = 0;
        int maxIndex = 0;
        int maxValue = array[0];
        for (int i = 0; i < size; ++i) {
            if (minValue > array[i]) {
                minValue = array[i];
                minIndex = i;
            }
            if (maxValue < array[i]) {
                maxValue = array[i];
                maxIndex = i;
            }
        }
        array[minIndex] = 0;
        array[maxIndex] = 99;
        System.out.println("min value = " + minValue + "\nmax value = " + maxValue);
        System.out.print("[");
        for (int i = 0; i < size; ++i) {
            if (i < size - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.print("]");
    }

    private static void task3() {
        System.out.println("Task 3: \nВведите размер массива: ");
        Scanner inputScanner = new Scanner(System.in);
        int size = inputScanner.nextInt();
        if (size <= 0) {
            System.out.println("Error");
            return;
        }
        float[] array = new float[size];
        for (int i = 0; i < size; ++i) {
            System.out.println("Введите целое число в массив (index = " + i + "):");
            float valueArray = inputScanner.nextFloat();
            array[i] = valueArray;
        }
        System.out.print("[");
        for (int i = 0; i < size; ++i) {
            if (i < size - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "]");
            }
        }
        for (int i = 0; i < size / 2; ++i) {
            float temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
        System.out.print("[");
        for (int i = 0; i < size; ++i) {
            if (i < size - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "]");
            }
        }
    }
}
