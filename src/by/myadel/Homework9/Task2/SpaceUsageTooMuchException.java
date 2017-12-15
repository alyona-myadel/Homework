package by.myadel.Homework9.Task2;

public class SpaceUsageTooMuchException extends Exception {
    private String russianMessage;

    public SpaceUsageTooMuchException(String russianMessage) {
        this.russianMessage = russianMessage;
    }

    public String getRussianMessage() {
        return russianMessage;
    }
}
