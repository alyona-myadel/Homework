package by.myadel.Homework6.Task1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BaseATM[] atms = new BaseATM[]{new BelarusbankATM(), new PriorbankATM()};
        Scanner inputScanner = new Scanner(System.in);
        for (BaseATM atm : atms) {
            System.out.println("Сколько денег вы хотите положить на счет в банкомате " + atm.viewBankName());
            int money = inputScanner.nextInt();
            if (money <= 0) {
                System.out.println("Сумма введена не верно.");
                return;
            }
            if (atm.replenish(money)) {
                System.out.println("Операция выполнена успешно.");
            } else {
                System.out.println("Оперция не выполнена.");
                return;
            }
            System.out.println("Ваш баланс составляет: " + atm.viewBalance());
            System.out.println("Сколько вы хотите снять денег ");
            int putMoney = inputScanner.nextInt();
            if (putMoney <= 0) {
                System.out.println("Сумма введена не верно.");
                return;
            }
            System.out.println("Вам выдали: ");
            List<Integer> list = atm.withdraw(putMoney);
            if (list == null) {
                System.out.println("Банкомате не может выдать данную сумму.");
                return;
            }
            for (Integer moneyDenomination : list) {
                System.out.print(moneyDenomination + " ");
            }
            System.out.println("\nДанные банкомата: \nбанк - " + atm.viewBankName() + " \nпроизводитель  - " + atm.viewManufacturer());
        }
    }
}