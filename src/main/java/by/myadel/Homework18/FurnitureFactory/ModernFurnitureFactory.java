package by.myadel.Homework18.FurnitureFactory;

import by.myadel.Homework18.Chair.ModernChair;
import by.myadel.Homework18.Sofa.ModernSofa;

public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public void createChair() {
        ModernChair modernChair = new ModernChair();
        modernChair.name();
        modernChair.style();
    }

    @Override
    public void createSofa() {
        ModernSofa modernSofa = new ModernSofa();
        modernSofa.name();
        modernSofa.style();
        modernSofa.numberOfSeats();
    }


}
