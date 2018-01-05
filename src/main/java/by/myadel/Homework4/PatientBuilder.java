package by.myadel.Homework4;

import java.util.Calendar;

public class PatientBuilder {
    private Patient patient = new Patient();

    public PatientBuilder setName(String name) {
        patient.setName(name);
        return this;
    }

    public PatientBuilder setSurname(String surname) {
        patient.setSurname(surname);
        return this;
    }

    public PatientBuilder setMiddleName(String middleName) {
        patient.setMiddleName(middleName);
        return this;
    }

    public PatientBuilder setYearOfBirth(int yearOfBirth) {
        patient.setYearOfBirth(yearOfBirth);
        return this;
    }

    public PatientBuilder setDiagnosis(String diagnosis) {
        patient.setDiagnosis(diagnosis);
        return this;
    }

    public Patient build() {
        return patient;
    }
}
