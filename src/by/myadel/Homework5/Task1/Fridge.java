package by.myadel.Homework5.Task1;

public class Fridge extends Appliance {
    private int numberOfCompressors;

    public Fridge(String model, String fabricator, int numberOfCompressors) {
        super(model, fabricator);
        this.numberOfCompressors = numberOfCompressors;
    }

    public int getNumberOfCompressors() {
        return numberOfCompressors;
    }

    @Override
    public String getName() {
        return "Холодильник";
    }

    @Override
    public void displayInfo() {
        System.out.println(getName() + ". Характеристики: \n\tмодель - " + super.getModel() + "\n\tпроизволитель - " + super.getFabricator() + "\n\tколичество компрессоров - " + getNumberOfCompressors());
    }
}
