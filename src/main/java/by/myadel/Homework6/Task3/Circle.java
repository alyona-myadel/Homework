package by.myadel.Homework6.Task3;

public class Circle implements MethodsOfFigures {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        double areaCircle = Math.pow(getRadius(), 2) * Math.PI;
        return areaCircle;
    }

    @Override
    public String getNameFigure() {
        return "окружности";
    }

}
