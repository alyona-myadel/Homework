package by.myadel.Homework6.Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите радиус круга: ");
        Scanner inputScanner = new Scanner(System.in);
        double radius = inputScanner.nextDouble();
        System.out.println("Введите ширину прямоугольника: ");
        double heightRectangle = inputScanner.nextDouble();
        System.out.println("Введите высоту прямоугольника: ");
        double weightRectangle = inputScanner.nextDouble();
        System.out.println("Введите длину стороны квадрата: ");
        double sideSguare = inputScanner.nextDouble();
        System.out.println("Введите длину первой стороны треугольника: ");
        double firstSideTriangle = inputScanner.nextDouble();
        System.out.println("Введите длину второй стороны треугольника: ");
        double secondSideTriangle = inputScanner.nextDouble();
        System.out.println("Введите длину третьей стороны треугольника: ");
        double thirdSideTriangle = inputScanner.nextDouble();
        MethodsOfFigures[] figures = new MethodsOfFigures[]{new Circle(radius), new Rectangle(heightRectangle, weightRectangle), new Square(sideSguare), new Triangle(firstSideTriangle, secondSideTriangle, thirdSideTriangle)};
        for (MethodsOfFigures figure : figures) {
            System.out.println("Площадь " + figure.getNameFigure() + " : " + figure.calculateArea());
        }
    }
}
