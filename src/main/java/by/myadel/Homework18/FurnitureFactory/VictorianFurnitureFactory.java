package by.myadel.Homework18.FurnitureFactory;

import by.myadel.Homework18.Chair.VictorianChair;
import by.myadel.Homework18.Sofa.VictorianSofa;

public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public void createChair() {
        VictorianChair victorianChair = new VictorianChair();
        victorianChair.name();
        victorianChair.style();
    }

    @Override
    public void createSofa() {
        VictorianSofa victorianSofa = new VictorianSofa();
        victorianSofa.name();
        victorianSofa.style();
        victorianSofa.numberOfSeats();
    }
}
