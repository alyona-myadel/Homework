package by.myadel.Homework5.Task1;

public class Washer extends Appliance {
    private int countSoftwareFunctions;

    public Washer(String model, String fabricator, int countSoftwareFunctions) {
        super(model, fabricator);
        this.countSoftwareFunctions = countSoftwareFunctions;
    }

    public int getCountSoftwareFunctions() {
        return countSoftwareFunctions;
    }

    @Override
    public String getName() {
        return "Стиральная машина";
    }

    @Override
    public void displayInfo() {
        System.out.println(getName() + ". Характеристики: \n\tмодель - " + super.getModel() + "\n\tпроизводитель - " + super.getFabricator() + "\n\tколичество програмных функций - " + getCountSoftwareFunctions());
    }
}
