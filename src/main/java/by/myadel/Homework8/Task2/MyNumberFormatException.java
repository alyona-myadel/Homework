package by.myadel.Homework8.Task2;

public class MyNumberFormatException extends Exception {
    private String russianMessage;

    public MyNumberFormatException(String russianMessage) {
        this.russianMessage = russianMessage;
    }

    public String getRussianMessage() {
        return russianMessage;
    }
}