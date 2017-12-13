package by.myadel.Homework8.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Введите первое число");
        try {
            calculator.setFirstValue(getDouble());
            System.out.println("Введите второе число");
            calculator.setSecondValue(getDouble());
        } catch (MyNumberFormatException ex) {
            System.out.println(ex.getRussianMessage());
            return;
        }
        System.out.println("Введите арифметическую операцию: '+' '-' '*' '/'");
        try {
            calculator.setOperation(getString());
        } catch (MyArithmeticOperationFormatException ep) {
            System.out.println(ep.getRussianMessage());
            return;
        }

        double result;
        try {
            result = calculator.result(calculator.getFirstValue(), calculator.getSecondValue());
        } catch (MyArithmeticException ex) {
            System.out.println(ex.getRussianMessage());
            return;
        }
        System.out.println("Результат:\n" + calculator.getFirstValue() + " " + calculator.getOperation() + " "
                + calculator.getSecondValue() + " = " + result);
    }

    public static double getDouble() throws MyNumberFormatException {
        Scanner inputScanner = new Scanner(System.in);
        String valueString = inputScanner.next().replace(",", ".").replace(" ", "");
        if (isDouble(valueString)) {
            return new Double(valueString);
        } else {
            throw new MyNumberFormatException("Вы неправильно набрали число");
        }
    }

    private static boolean isDouble(String string) throws NumberFormatException {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static String getString() throws MyArithmeticOperationFormatException {
        Scanner inputScanner = new Scanner(System.in);
        String valueString = inputScanner.next();
        if (valueString.equals("/") || valueString.equals("*") || valueString.equals("+") || valueString.equals("-")) {
            return valueString;
        } else {
            throw new MyArithmeticOperationFormatException("Неправильно введена арифметическая операция");
        }
    }
}