package by.myadel.Homework18;


import by.myadel.Homework18.FurnitureFactory.FurnitureFactory;
import by.myadel.Homework18.FurnitureFactory.ModernFurnitureFactory;
import by.myadel.Homework18.FurnitureFactory.VictorianFurnitureFactory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory victorianFurniture = new VictorianFurnitureFactory();
        victorianFurniture.createChair();
        victorianFurniture.createSofa();
        FurnitureFactory modernFurniture = new ModernFurnitureFactory();
        modernFurniture.createChair();
        modernFurniture.createSofa();
    }
}
