package by.myadel.Homework8.Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        calculator.setFirstValue(inputScanner.nextDouble());
        System.out.println("Введите второе число");
        calculator.setSecondValue(inputScanner.nextDouble());
        System.out.println("Введите арифметическую операцию: '+' '-' '*' '/'");
        calculator.setOperation(inputScanner.next());
        System.out.println("Результат:\n" + calculator.getFirstValue() + " " + calculator.getOperation() + " "
                + calculator.getSecondValue() + " = " + calculator.result());
    }
}