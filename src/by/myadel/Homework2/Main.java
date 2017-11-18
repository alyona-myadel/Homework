package by.myadel.Homework2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите номер задачи 1..6 (для завершения программы наберите 0): ");
            Scanner inputScanner = new Scanner(System.in);
            int taskNumber = inputScanner.nextInt();
            switch (taskNumber) {
                case 0:
                    return;
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                default:
                    System.out.println("Вы неправильно набрали номер.");
            }
        }
    }

    private static void task1() {
        System.out.println("Task 1:");
        int[] array = askIntArray();
        int minValue = array[0];
        int minIndex = 0;
        int maxIndex = 0;
        int maxValue = array[0];
        for (int i = 0; i < array.length; ++i) {
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
        for (int i = 0; i < array.length; ++i) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.print("]");
    }

    private static void task2() {
        System.out.println("Task 2:");
        float[] array = askFloatArray();
        Map<String, Integer> doubles = new HashMap<String, Integer>();
        for (int i = 0; i < array.length; ++i) {
            String key = String.valueOf(array[i]);
            if (doubles.containsKey(key)) {
                doubles.put(key, doubles.get(key) + 1);
            } else {
                doubles.put(key, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : doubles.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("[" + entry.getKey() + "]" + " - повторений " + entry.getValue());
            }
        }
    }

    private static void task3() {
        System.out.println("Task 3:");
        float[] array = askFloatArray();
        System.out.print("[");
        for (int i = 0; i < array.length; ++i) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "]");
            }
        }
        for (int i = 0; i < array.length / 2; ++i) {
            float temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.print("[");
        for (int i = 0; i < array.length; ++i) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "]");
            }
        }
    }

    private static void task4() {
        System.out.println("Task 4: \nВведите число: ");
        Scanner inputScanner = new Scanner(System.in);
        int number = Math.abs(inputScanner.nextInt());
        System.out.print(number);
        if (isDigitsAscend(number)) {
            System.out.println(" - образует возрастающую последовательность");
        } else {
            System.out.println(" - не образует возрастающую последовательность");
        }
    }

    private static boolean isDigitsAscend(int number) {
        int currentNumber = number;
        int previousLastDigit = 9;
        while (currentNumber != 0) {
            int lastDigit = currentNumber % 10;
            if (lastDigit > previousLastDigit) {
                return false;
            }
            previousLastDigit = lastDigit;
            currentNumber /= 10;
        }
        return true;
    }

    private static void task5() {
        System.out.println("Task 5:");
        int[] array = askIntArray();
        System.out.println("Каким методом хотите отсортировать массив? \nСортировка вставками - 1 \nСортировка пузырьком - 2 \nСортировка выбором - 3");
        Scanner inputScanner = new Scanner(System.in);
        int methodSort = inputScanner.nextInt();
        switch (methodSort) {
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
        System.out.println("Время сортировки массива вставками " + String.format("%,12d", measureTime1(testSize)) + " ns");
        System.out.println("Время сортировки массива пузырьком " + String.format("%,12d", measureTime2(testSize)) + " ns");
        System.out.println("Время сортировки массива выбором " + String.format("%,12d", measureTime3(testSize)) + " ns");
        System.out.println("Но это не точно =)");
    }

    private static long measureTime1(int testSize) {
        int[] testArray = new int[testSize];
        for (int i = 0; i < testSize; ++i) {
            testArray[i] = (int) (Math.random() * 99999);
        }
        long startTime = System.nanoTime();
        insertionSort(testArray);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long measureTime2(int testSize) {
        long startTime = System.nanoTime();
        bubbleSort(randomArray(testSize));
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long measureTime3(int testSize) {
        long startTime = System.nanoTime();
        selectionSort(randomArray(testSize));
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static int[] randomArray(int testSize) {
        int[] testArray = new int[testSize];
        for (int i = 0; i < testSize; ++i) {
            testArray[i] = (int) (Math.random() * 99999);
        }
        return testArray;
    }

    private static int[] insertionSort(int array[]) {
        for (int j, i = 1; i < array.length; ++i) {
            int value = array[i];
            for (j = i - 1; j >= 0 && array[j] > value; --j) {
                array[j + 1] = array[j];
            }
            array[j + 1] = value;
        }
        return array;
    }

    private static int[] bubbleSort(int array[]) {
        for (int i = array.length - 1; i >= 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    private static int[] selectionSort(int array[]) {
        for (int i = 0; i < array.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
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

    private static float[] askFloatArray() {
        int size = askArraySize();
        if (size <= 0) {
            return new float[]{};
        }
        float array[] = new float[size];
        Scanner inputScanner = new Scanner(System.in);
        for (int i = 0; i < size; ++i) {
            System.out.println("Введите целое число в массив (index = " + i + "):");
            float valueArray = inputScanner.nextFloat();
            array[i] = valueArray;
        }
        return array;
    }
}