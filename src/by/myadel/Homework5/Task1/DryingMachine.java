package by.myadel.Homework5.Task1;

public class DryingMachine extends Washer {

    public DryingMachine(String model, String fabricator, int countSoftwareFunctions) {
        super(model, fabricator, countSoftwareFunctions);
    }

    @Override
    public String getName() {
        return "Сушильная машина";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}