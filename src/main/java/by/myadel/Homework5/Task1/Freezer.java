package by.myadel.Homework5.Task1;

public class Freezer extends Fridge {
    private String design;

    public Freezer(String model, String fabricator, int numberOfCompressors, String design) {
        super(model, fabricator, numberOfCompressors);
        this.design = design;
    }

    @Override
    public String getName() {
        return "Морозильник";
    }

    public String getDesign() {
        return design;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("\tконструкция - " + getDesign());
    }
}
