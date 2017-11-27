package by.myadel.Homework4;

import java.util.Calendar;
import java.util.Date;

public class Patient {
    private String name;
    private String surname;
    private String middleName;
    private int yearOfBirth;
    private String diagnosis;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getAge() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR) - yearOfBirth;
    }

    public boolean isMatchSearchParameters(PatientSearchParameters searchParameters) {
        if (searchParameters.getSearchName().equals(getName()) || searchParameters.getSearchSurname().equals(getSurname()) || searchParameters.getSearchYearOfBirth() == getYearOfBirth()) {
            return true;
        }
        return false;
    }
}
