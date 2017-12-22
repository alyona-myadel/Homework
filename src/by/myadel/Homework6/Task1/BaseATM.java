package by.myadel.Homework6.Task1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class BaseATM implements Withdrawable, Replenishable, BalanceViewable, ManufacturerViewable, BankNameViewable {
    protected Map<Integer, Integer> atmStorage = new HashMap<>();

    @Override
    public List<Integer> withdraw(int money) {
        List<Integer> denominations = breakUpMoney(money);
        if (denominations == null) {
            return null;
        }
        Map<Integer, Integer> denominationCounts = new HashMap<>();
        for (Integer denomination : denominations) {
            if (denominationCounts.containsKey(denomination)) {
                denominationCounts.put(denomination, denominationCounts.get(denomination) + 1);
            } else {
                denominationCounts.put(denomination, 1);
            }
        }
        for (Integer denomination : denominationCounts.keySet()) {
            if (atmStorage.get(denomination) == null || denominationCounts.get(denomination) > atmStorage.get(denomination)) {
                return null;
            }
        }
        for (Integer denomination : denominationCounts.keySet()) {
            atmStorage.put(denomination, atmStorage.get(denomination) - denominationCounts.get(denomination));
        }
        return denominations;
    }

    @Override
    public boolean replenish(int money) {
        List<Integer> denominations = breakUpMoney(money);
        if (denominations != null) {
            for (Integer denomination : denominations) {
                if (atmStorage.containsKey(denomination)) {
                    atmStorage.put(denomination, atmStorage.get(denomination) + 1);
                } else {
                    atmStorage.put(denomination, 1);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int viewBalance() {
        int balance = 0;
        for (Integer denomination : atmStorage.keySet()) {
            balance += atmStorage.get(denomination) * denomination;
        }
        return balance;
    }

    protected abstract List<Integer> getAvailableDenominations();

    protected List<Integer> breakUpMoney(int money) {
        List<Integer> availableDenominations = getAvailableDenominations();
        for (Integer availableDenomination : availableDenominations) {
            if (money >= availableDenomination) {
                List<Integer> brokenMoney = breakUpMoney(money - availableDenomination);
                if (brokenMoney != null) {
                    brokenMoney.add(availableDenomination);
                    return brokenMoney;
                }
            }
        }
        if (money == 0) {
            return new LinkedList<>();
        }
        return null;
    }
}
