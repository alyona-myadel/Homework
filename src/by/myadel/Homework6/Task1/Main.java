package by.myadel.Homework6.Task1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BelarusbankATM belarusbankATM = new BelarusbankATM();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Сколько денег вы хотите положить на счет в банкомате " + belarusbankATM.viewBankName());
        int money = inputScanner.nextInt();
        if (money <= 0) {
            System.out.println("Сумма введена не верно.");
            return;
        }
        if (belarusbankATM.replenish(money)) {
            System.out.println("Операция выполнена успешно.");
        } else {
            System.out.println("Оперция не выполнена.");
            return;
        }
        System.out.println("Ваш баланс составляет: " + belarusbankATM.viewBalance());
        System.out.println("Сколько вы хотите снять денег ");
        int putMoney = inputScanner.nextInt();
        if (putMoney <= 0) {
            System.out.println("Сумма введена не верно.");
            return;
        }
        System.out.println("Вам выдали: ");
        List<Integer> list = belarusbankATM.withdraw(putMoney);
        if (list == null) {
            System.out.println("Банкомате не может выдать данную сумму.");
            return;
        }
        for (Integer moneyDenomination : list) {
            System.out.print(moneyDenomination + " ");
        }
        System.out.println("\n Данные банкомата: \nбанк - " + belarusbankATM.viewBankName() + " \nпроизводитель  - " + belarusbankATM.viewManufacturer());
    }
}