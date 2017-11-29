package by.myadel.Homework5.Task2;

public class NumberOfBills {
    private int numberOfDenominations100;
    private int numberOfDenominations50;
    private int numberOfDenominations20;

    public NumberOfBills(int numberOfDenominations100, int numberOfDenominations50, int numberOfDenominations20) {
        this.numberOfDenominations100 = numberOfDenominations100;
        this.numberOfDenominations50 = numberOfDenominations50;
        this.numberOfDenominations20 = numberOfDenominations20;
    }

    public int getNumberOfDenominations100() {
        return numberOfDenominations100;
    }

    public void setNumberOfDenominations100(int numberOfDenominations100) {
        this.numberOfDenominations100 = numberOfDenominations100;
    }

    public int getNumberOfDenominations50() {
        return numberOfDenominations50;
    }

    public void setNumberOfDenominations50(int numberOfDenominations50) {
        this.numberOfDenominations50 = numberOfDenominations50;
    }

    public int getNumberOfDenominations20() {
        return numberOfDenominations20;
    }

    public void setNumberOfDenominations20(int numberOfDenominations20) {
        this.numberOfDenominations20 = numberOfDenominations20;
    }

    public int getNumberOfDenominations(int denominations) {
        switch (denominations) {
            case 100:
                return getNumberOfDenominations100();
            case 50:
                return getNumberOfDenominations50();
            case 20:
                return getNumberOfDenominations20();
            default:
                return 0;
        }
    }

    public void setNumberOfDenominations(int denomination, int numberOfDenominations) {
        switch (denomination) {
            case 100:
                setNumberOfDenominations100(numberOfDenominations);
                break;
            case 50:
                setNumberOfDenominations50(numberOfDenominations);
                break;
            case 20:
                setNumberOfDenominations20(numberOfDenominations);
                break;
        }
    }

    public void printNumberOfBills() {
        System.out.println("100 р. - " + getNumberOfDenominations100() + "; 50 р. - " + getNumberOfDenominations50() + "; 20р. - " + getNumberOfDenominations20() + ".");
    }
}
