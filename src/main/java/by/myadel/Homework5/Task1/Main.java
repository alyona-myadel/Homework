package by.myadel.Homework5.Task1;

public class Main {
    public static void main(String[] args) {
        Fridge fridge = new Fridge("RB37J5000B1", "Samsung Electronics Co", 1);
        Freezer freezer = new Freezer("ATLANT", "ЗАО «АТЛАНТ»", 1, "морозильник");
        Washer washer = new Washer("F1096ND3", "LG Electronics", 7);
        DryingMachine dryingMachine = new DryingMachine("ZDP7202PZ", "AB Electrolux, Швеция", 3);

        washer.displayInfo();
        dryingMachine.displayInfo();
        fridge.displayInfo();
        freezer.displayInfo();
    }
}
