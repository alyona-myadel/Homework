package by.myadel.Homework5.Task1;

public abstract class Appliance {

    private String model;
    private String fabricator;

    public Appliance(String model, String fabricator) {
        this.model = model;
        this.fabricator = fabricator;
    }

    protected Appliance() {
    }

    public String getModel() {
        return model;
    }

    public String getFabricator() {
        return fabricator;
    }

    public abstract String getName();

    public abstract void displayInfo();
}
