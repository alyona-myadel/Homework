package by.myadel.Homework6.Task1;

import java.util.LinkedList;
import java.util.List;

public class PriorbankATM extends BaseATM implements BankNameViewable {
    private List<Integer> availableDenominations;

    @Override
    protected List<Integer> getAvailableDenominations() {
        if (availableDenominations == null) {
            availableDenominations = new LinkedList<>();
            for (int value : new int[]{100, 50, 20, 10, 5}) {
                availableDenominations.add(Integer.valueOf(value));
            }
        }
        return availableDenominations;
    }

    @Override
    public String viewManufacturer() {
        return "China Electronics";
    }

    @Override
    public String viewBankName() {
        return "Приорбанк";
    }
}
