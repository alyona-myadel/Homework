package by.myadel.Homework5.Task2;

public class Atm {
    NumberOfBills bills = new NumberOfBills(0, 0, 0);

    public boolean putMoney(int money) {
        if (money <= 0) {
            return false;
        }
        int denominations[] = new int[]{100, 50, 20};
        int amountOfmoney[] = new int[denominations.length];
        for (int i = 0; i < denominations.length && money != 0; ++i) {
            int amount = money / denominations[i];
            amountOfmoney[i] = amount;
            money -= amount * denominations[i];
        }
        if (money != 0) {
            return false;
        }
        for (int i = 0; i < denominations.length; ++i) {
            bills.setNumberOfDenominations(denominations[i], amountOfmoney[i]);
        }
        return true;
    }

    public void printBalance() {
        bills.printNumberOfBills();
    }

    public GetMoneyResult getMoney(int outputMoney) {
        if (outputMoney <= 0) {
            return new GetMoneyResult(false, new NumberOfBills(0, 0, 0));
        }
        int denominations[] = new int[]{100, 50, 20};
        int amountOfMoney[] = new int[denominations.length];
        for (int i = 0; i < denominations.length && outputMoney != 0; ++i) {
            int amount = outputMoney / denominations[i];
            if (bills.getNumberOfDenominations(denominations[i]) >= amount) {
                amountOfMoney[i] = amount;
                bills.setNumberOfDenominations(denominations[i], bills.getNumberOfDenominations(denominations[i]) - amountOfMoney[i]);
                outputMoney -= amountOfMoney[i] * denominations[i];
            }
        }
        if (outputMoney != 0) {
            return new GetMoneyResult(false, new NumberOfBills(0, 0, 0));
        } else {
            return new GetMoneyResult(true, new NumberOfBills(amountOfMoney[0], amountOfMoney[1], amountOfMoney[2]));
        }
    }
}
