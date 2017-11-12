package by.myadel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        System.out.println("Task 1:");
        String string = "Эта строка поделена пополам";
        int size = string.length();
        System.out.println("Количество символов в строке = " + size);
        int middleIndex = size / 2;
        String stringLeft = string.substring(0, middleIndex);
        String stringRight = string.substring(middleIndex, size);
        System.out.println("Левая половина строки = " + stringLeft);
        System.out.println("Правая половина строки = " + stringRight);
    }

    private static void task2() {
        System.out.println("Task 2: \nВведите число: ");
        Scanner number = new Scanner(System.in);
        int initialNumber = number.nextInt();
        int remainder = Math.abs(initialNumber) % 10;
        if (remainder == 7) {
            System.out.println("Последеняя цифра числа " + initialNumber + " равна 7");
        } else {
            System.out.println("Последеняя цифра числа " + initialNumber + " не равна 7");
        }
    }
}
