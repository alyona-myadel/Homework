package by.myadel.Homework4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int countPatient = askCountPatient();
        if (countPatient <= 0) {
            System.out.println("Вы неправильно набрили количество пациентов");
            return;
        }
        PatientDataStore patientDataStore = new PatientDataStore();
        Scanner inputScanner = new Scanner(System.in);
        for (int i = 0; i < countPatient; ++i) {
            PatientBuilder patientBuilder = new PatientBuilder();
            System.out.println("Введите имя пациента:");
            patientBuilder.setName(inputScanner.next());
            System.out.println("Введите фамилию пациента:");
            patientBuilder.setSurname(inputScanner.next());
            System.out.println("Введите отчество пациента:");
            patientBuilder.setMiddleName(inputScanner.next());
            System.out.println("Введите год рождения пациента:");
            patientBuilder.setYearOfBirth(inputScanner.nextInt());
            System.out.println("Введите диагноз пациента:");
            patientBuilder.setDiagnosis(inputScanner.next());
            patientDataStore.addPatient(patientBuilder.build());
        }
        for (Patient patient : patientDataStore.getAllPatients()) {
            System.out.println("Пациент " + patient.getName() + " " + patient.getSurname() + " " + patient.getMiddleName() + " возраст = " + patient.getAge() + " года");
        }
        PatientSearchParametersBuilder parametersBuilder = new PatientSearchParametersBuilder();
        System.out.println("Введите имя пациента: ");
        parametersBuilder.setName(inputScanner.next());
        System.out.println("Введите год рождения пациента: ");
        parametersBuilder.setYearOfBirth(inputScanner.nextInt());
        for (Patient patient : patientDataStore.getAllPatients())
            if (patient.isMatchSearchParameters(parametersBuilder.build())) {
                System.out.println("Пациент " + patient.getName() + " " + patient.getSurname() + " " + patient.getMiddleName() + " возраст = " + patient.getAge() + " года");
            } else {
                System.out.println("Пациент отсутствует в базе данных");
            }
    }

    private static int askCountPatient() {
        System.out.println("Введите количество пациентов: ");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }
}
