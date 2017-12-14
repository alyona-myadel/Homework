package by.myadel.Homework8.Task4;

import java.util.LinkedList;
import java.util.List;

public class PatientDataStore {
    private LinkedList<Patient> patients = new LinkedList<>();

    public void addPatient(Patient concretePatient) {
        patients.add(concretePatient);
    }

    public void removePatient(int indexPatient) {
        patients.remove(indexPatient);
    }

    public Patient searchPatient(PatientSearchParameters parameters) {
        for (int i = 0; i < patients.size(); ++i) {
            if (patients.get(i).isMatchSearchParameters(parameters)) {
                return patients.get(i);
            }
        }
        return null;
    }

    public List<Patient> getAllPatients() {
        return patients;
    }
}