package by.myadel.Homework6.Task3;

public class Triangle implements MethodsOfFigures {
    private double firstSide;
    private double secondSige;
    private double thirdSide;

    public Triangle(double firstSide, double secondSige, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSige = secondSige;
        this.thirdSide = thirdSide;
    }

    public double getFirstSide() {
        return firstSide;
    }

    public void setFirstSide(double firstSide) {
        this.firstSide = firstSide;
    }

    public double getSecondSige() {
        return secondSige;
    }

    public void setSecondSige(double secondSige) {
        this.secondSige = secondSige;
    }

    public double getThirdSide() {
        return thirdSide;
    }

    public void setThirdSide(double thirdSide) {
        this.thirdSide = thirdSide;
    }

    @Override
    public double calculateArea() {
        double semiperimeter = (getFirstSide() + getSecondSige() + getThirdSide()) / 2;
        double areaTriangle = Math.sqrt(semiperimeter * (semiperimeter - getFirstSide()) * (semiperimeter - getSecondSige()) * (semiperimeter - getThirdSide()));
        return areaTriangle;
    }

    @Override
    public String getNameFigure() {
        return "треугольника";
    }
}