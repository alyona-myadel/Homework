package by.myadel.Homework2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //task1();
        //task3();
        //task4();
        task5();
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

    private static void task4() {
        System.out.println("Task 4: \nВведите размер массива: ");
        Scanner inputScanner = new Scanner(System.in);
        int size = inputScanner.nextInt();
        if (size <= 0) {
            System.out.println("Error");
            return;
        }
        float[] array = new float[size];
        for (int i = 0; i < size; ++i) {
            System.out.println("Введите целое число в массив (index = " + i + "):");
            float value = inputScanner.nextFloat();
            array[i] = value;
        }
        System.out.print("[");
        for (int i = 0; i < size; ++i) {
            if (i < size - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i] + "]");
            }
        }
        if (isAscendArray(array)) {
            System.out.print(" - образует возрастающую последовательность");
        } else {
            System.out.print(" - не образует возрастающую последовательность");
        }
    }

    private static boolean isAscendArray(float[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void task5() {
        System.out.println("Task 5: \nВведите размер массива: ");
        Scanner inputScanner = new Scanner(System.in);
        int size = inputScanner.nextInt();
        if (size <= 0) {
            System.out.println("Error");
            return;
        }
        int[] array = new int[size];
        for (int i = 0; i < size; ++i) {
            System.out.println("Введите целое число в массив (index = " + i + "):");
            int value = inputScanner.nextInt();
            array[i] = value;
        }
        System.out.println("Каким методом хотите отсортировать массив? \nСортировка вставками - 1 \nСортировка пузырьком - 2 \nСортировка выбором - 3" );
        int methodSort = inputScanner.nextInt();
        switch (methodSort){
            case 1:
                insertionSort(array);
                break;
            case 2:
                bubbleSort(array);
                break;
            case 3:
                selectionSort(array);
                break;
            default:
                System.out.println("Неправильно выбрали номер сортировки");
                break;
        }
        System.out.println((Arrays.toString(array)));
        System.out.println("Проверка скорости выполения сортировки (величина массива = 1000)");
        int testSize = 1000;
        System.out.println("Время сортировки массива вставками " + String.format("%,12d",measureTime1(testSize)) + " ns");
        System.out.println("Время сортировки массива пузырьком " + String.format("%,12d",measureTime2(testSize)) + " ns");
        System.out.println("Время сортировки массива выбором " + String.format("%,12d",measureTime3(testSize)) + " ns");
        System.out.println("Но это не точно =)");
    }

    private static long measureTime1(int testSize){
        int[] testArray = new int[testSize];
        for (int i = 0; i < testSize; ++i){
            testArray[i] = (int)(Math.random()*99999);
        }
        long startTime = System.nanoTime();
        insertionSort(testArray);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long measureTime2(int testSize){
        long startTime = System.nanoTime();
        bubbleSort(randomArray(testSize));
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long measureTime3(int testSize){
        long startTime = System.nanoTime();
        selectionSort(randomArray(testSize));
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static int[] randomArray(int testSize){
        int[] testArray = new int[testSize];
        for (int i = 0; i < testSize; ++i){
            testArray[i] = (int)(Math.random()*99999);
        }
        return testArray;
    }

    private static int[] insertionSort(int array[]){
        for (int j, i = 1; i < array.length; ++i){
            int value = array[i];
            for (j = i - 1 ; j >= 0 && array[j] > value; --j){
                array[j + 1] = array[j];
            }
            array[j +1] = value;
        }
        return array;
    }

    private static int[] bubbleSort(int array[]){
        for (int i = array.length - 1; i >= 0 ; --i){
            for (int j = 0; j < i; ++j){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    private static int[] selectionSort(int array[]){
            for (int i = 0; i < array.length - 1; ++i){
                int minIndex = i;
                for (int j = i + 1; j < array.length; ++j){
                    if (array[j] < array[minIndex]){
                        minIndex = j;
                    }
                }
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        return array;
    }
}
