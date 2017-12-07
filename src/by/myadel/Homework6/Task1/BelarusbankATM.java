package by.myadel.Homework6.Task1;

import java.util.LinkedList;
import java.util.List;

public class BelarusbankATM extends BaseATM implements BankNameViewable {
    private List<Integer> availableDenominations;

    @Override
    protected List<Integer> getAvailableDenominations() {
        if (availableDenominations == null) {
            availableDenominations = new LinkedList<>();
            for (int value : new int[]{100, 50, 20}) {
                availableDenominations.add(Integer.valueOf(value));
            }
        }
        return availableDenominations;
    }

    @Override
    public String viewManufacturer() {
        return "ООО \"Великие разрабочики банкоматов\"";
    }

    @Override
    public String viewBankName() {
        return "Беларусьбанк";
    }
}
