package by.myadel.Homework8.Task4;

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

    public Patient build() {
        return patient;
    }
}