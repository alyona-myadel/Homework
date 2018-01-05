package by.myadel.Homework6.Task3;

public class Rectangle implements MethodsOfFigures {
    private double weight;
    private double height;

    public Rectangle(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return getHeight() * getWeight();
    }

    @Override
    public String getNameFigure() {
        return "прямоугольника";
    }
}
