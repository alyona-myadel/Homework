package by.myadel.Homework9.Task2;

public class Furniture implements AbleToReceive {
    private String nameFurniture;
    private double areaFurniture;

    public Furniture(String nameFurniture, double areaFurniture) {
        this.nameFurniture = nameFurniture;
        this.areaFurniture = areaFurniture;
    }

    public double getAreaFurniture() {
        return areaFurniture;
    }

    public String getNameFurniture() {
        return nameFurniture;
    }
}
