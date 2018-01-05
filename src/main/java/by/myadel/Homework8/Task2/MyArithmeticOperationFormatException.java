package by.myadel.Homework8.Task2;

public class MyArithmeticOperationFormatException extends Exception {
    private String russianMessage;

    public MyArithmeticOperationFormatException(String russianMessage) {
        this.russianMessage = russianMessage;
    }

    public String getRussianMessage() {
        return russianMessage;
    }
}