package by.myadel.Homework4;

public class PatientSearchParametersBuilder {
    PatientSearchParameters parameters = new PatientSearchParameters();

    public PatientSearchParametersBuilder setName(String name) {
        parameters.setSearchName(name);
        return this;
    }

    public PatientSearchParametersBuilder setSurname(String surname) {
        parameters.setSearchSurname(surname);
        return this;
    }

    public PatientSearchParametersBuilder setYearOfBirth(int yearOfBirth) {
        parameters.setSearchYearOfBirth(yearOfBirth);
        return this;
    }

    public PatientSearchParameters build() {
        return parameters;
    }
}
