package by.myadel.Homework6.Task3;

public class Square implements MethodsOfFigures {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return Math.pow(getSide(), 2);
    }

    @Override
    public String getNameFigure() {
        return "квадрата";
    }
}
