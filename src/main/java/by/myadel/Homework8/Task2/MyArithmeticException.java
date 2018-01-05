package by.myadel.Homework8.Task2;

public class MyArithmeticException extends Exception {
    private String russianMessage;

    public MyArithmeticException(String russianMessage) {
        this.russianMessage = russianMessage;
    }

    public String getRussianMessage() {
        return russianMessage;
    }
}