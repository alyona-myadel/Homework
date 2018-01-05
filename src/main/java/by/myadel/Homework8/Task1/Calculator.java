package by.myadel.Homework8.Task1;

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

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double result() {
        switch (operation) {
            case "*":
                return firstValue * secondValue;
            case "+":
                return firstValue + secondValue;
            case "-":
                return firstValue - secondValue;
            case "/":
                return firstValue / secondValue;
        }
        return null;
    }
}