package by.myadel.Homework8.Task4;

public class MyException extends Exception {
    private String russianMessage;

    public MyException(String russianMessage) {
        this.russianMessage = russianMessage;
    }

    public String getRussianMessage() {
        return russianMessage;
    }
}