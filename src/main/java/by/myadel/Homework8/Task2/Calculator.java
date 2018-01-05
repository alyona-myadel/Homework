package by.myadel.Homework8.Task2;

public class Calculator {
    private double firstValue;
    private double secondValue;
    private String operation;

    public double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    public double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String valueString) {
        this.operation = operation;
    }

    public double result(double firstValue, double secondValue) throws MyArithmeticException {
        switch (operation) {
            case "*":
                return firstValue * secondValue;
            case "+":
                return firstValue + secondValue;
            case "-":
                return firstValue - secondValue;
            case "/":
                if (secondValue == 0) {
                    throw new MyArithmeticException("на нуль делить нельзя!");
                }
                return firstValue / secondValue;
            default:
                return 0;
        }
    }
}