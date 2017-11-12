package by.myadel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите номер задачи 1..6: ");
        Scanner inputScanner = new Scanner(System.in);
        int taskNumber = inputScanner.nextInt();
        switch (taskNumber) {
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
            case 6:
                task6();
                break;
            default:
                System.out.println("Вы неправильно набрали номер.");
        }
    }

    private static void task1() {
        System.out.println("Task 1: \nВведите строку: ");
        Scanner inputScanner = new Scanner(System.in);
        String string = inputScanner.nextLine();
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

    private static void task3() {
        System.out.println("Task 3: \nВведите длину прямоугольника: ");
        Scanner inputScanner = new Scanner(System.in);
        double lengthRectangle = inputScanner.nextDouble();
        System.out.println("Введите ширину прямоугольника: ");
        double widthRectangle = inputScanner.nextDouble();
        System.out.println("Введите диаметр круга: ");
        double radiusCircle = inputScanner.nextDouble();
        double diameter = radiusCircle * 2;
        double diagonal = Math.sqrt(Math.pow(lengthRectangle, 2) + Math.pow(widthRectangle, 2));
        if (diameter >= diagonal) {
            System.out.println("Диаметр круга " + diameter + " больше диагонали прямоугольника " + diagonal);
            System.out.println("Круг закрывает прямоугольник.");
        } else {
            System.out.println("Диаметр круга " + diameter + " меньше диагонали прямоугольника " + diagonal);
            System.out.println("Круг не закрывает прямоугольник.");
        }
    }

    private static void task4() {
        System.out.println("Task 4: \nВведите количество денег в вашем кошельке: ");
        Scanner inputScanner = new Scanner(System.in);
        int money = inputScanner.nextInt();
        System.out.println("У вас есть: " + money + " " + choiceOfCase(money, "рубль", "рубля", "рублей"));
    }

    private static String choiceOfCase(int money, String one, String few, String many) {
        int moneyAbs = Math.abs(money);
        int twoLastNumbers = moneyAbs % 100;
        int oneLastNumber = moneyAbs % 10;
        if (twoLastNumbers == 0 || (twoLastNumbers >= 11 && twoLastNumbers <= 14)) {
            return many;
        } else if (twoLastNumbers == 1 || oneLastNumber == 1) {
            return one;
        } else if ((twoLastNumbers >= 2 && twoLastNumbers <= 4) || (oneLastNumber >= 2 && oneLastNumber <= 4)) {
            return few;
        }
        return many;
    }

    private static void task5() {
        System.out.println("Task 5: \nВведите строку в которой содержатся \"#\" и \"?\": ");
        Scanner inputScanner = new Scanner(System.in);
        String text = inputScanner.nextLine();
        String textResult = text.replace("?", "").replace("#", "HELLO");
        System.out.println(textResult);
    }

    private static void task6() {
        System.out.println("Task 6: \nВведите х: ");
        Scanner inputScanner = new Scanner(System.in);
        double x = inputScanner.nextDouble();
        System.out.println("Введите t: ");
        double t = inputScanner.nextDouble();
        System.out.println("Введите s: ");
        double s = inputScanner.nextDouble();
        double denominator = Math.sqrt(1 + Math.pow(x, s));
        if (denominator == 0) {
            System.out.println("Нельзя делить на нуль!");
            return;
        }
        double y = Math.pow(Math.sin((Math.pow(x, t))), 2) / denominator;
        System.out.println("Результат y = " + y);
    }
}
