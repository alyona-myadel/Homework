package by.myadel.Homework5.Task2;

public class GetMoneyResult {
    private boolean status;
    private NumberOfBills numberOfBills;

    public GetMoneyResult(boolean status, NumberOfBills numberOfBills) {
        this.status = status;
        this.numberOfBills = numberOfBills;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public NumberOfBills getNumberOfBills() {
        return numberOfBills;
    }

    public void setNumberOfBills(NumberOfBills numberOfBills) {
        this.numberOfBills = numberOfBills;
    }
}
