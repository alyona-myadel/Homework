package by.myadel.Homework5.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Atm atm = new Atm();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Сколько денег вы хотите положить на счет: ");
        int money = inputScanner.nextInt();
        if (atm.putMoney(money)) {
            System.out.println("Операция выполнена успешно.");
        } else {
            System.out.println("Сумма введена неверно");
        }
        System.out.print("Проверка баланса банкомата: ");
        atm.printBalance();
        System.out.println("Сколько денег вы хотите снять: ");
        int outputMoney = inputScanner.nextInt();
        System.out.print("Вам выдали: ");
        atm.getMoney(outputMoney).getNumberOfBills().printNumberOfBills();
        System.out.print("Проверка баланса банкомата: ");
        atm.printBalance();

    }
}