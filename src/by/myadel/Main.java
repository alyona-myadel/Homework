package by.myadel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
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

    private static void task3(){
        System.out.println("Task 3: \nВведите длину прямоугольника: ");
        Scanner inputScanner = new Scanner(System.in);
        double lengthRectangle = inputScanner.nextDouble();
        System.out.println("Введите ширину прямоугольника: ");
        double widthRectangle = inputScanner.nextDouble();
        System.out.println("Введите диаметр круга: ");
        double radiusCircle = inputScanner.nextDouble();
        double diameter = radiusCircle*2;
        double diagonal = Math.sqrt(Math.pow(lengthRectangle, 2)+ Math.pow(widthRectangle, 2));
        if (diameter >= diagonal){
            System.out.println("Диаметр круга " + diameter + " больше диагонали прямоугольника " + diagonal);
            System.out.println("Круг закрывает прямоугольник.");
        } else {
            System.out.println("Диаметр круга " + diameter + " меньше диагонали прямоугольника " + diagonal);
            System.out.println("Круг не закрывает прямоугольник.");
        }
    }

    private static void task4(){
        System.out.println("Task 4: \nВведите количество денег в вашем кошельке: ");
        Scanner inputScanner = new Scanner(System.in);
        int money = inputScanner.nextInt();
        System.out.println("У вас есть: " + money + " " + choiceOfCase(money, "рубль", "рубля", "рублей"));
    }

    private static String choiceOfCase(int money, String one, String few, String many){
        int moneyAbs = Math.abs(money);
        int twoLastNumbers = moneyAbs%100;
        int oneLastNumber = moneyAbs%10;
        if (twoLastNumbers == 0 || (twoLastNumbers >= 11 && twoLastNumbers <= 14)){
            return many;
        } else if (twoLastNumbers == 1 || oneLastNumber == 1){
                return one;
        } else if ((twoLastNumbers >= 2 && twoLastNumbers <= 4) || (oneLastNumber >= 2 && oneLastNumber <= 4)){
            return few;
        }
        return many;
    }
}
