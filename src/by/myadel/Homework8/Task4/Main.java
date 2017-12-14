package by.myadel.Homework8.Task4;

import java.io.*;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\alena\\IdeaProjects\\test2.txt");
        PatientDataStore patientDataStore = new PatientDataStore();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                PatientBuilder patientBuilder = new PatientBuilder();
                int indexName = line.indexOf("|");
                String name = line.substring(0, indexName);
                patientBuilder.setName(name);
                int indexSurname = line.indexOf("|", indexName + 1);
                String surname = line.substring(indexName + 1, indexSurname);
                patientBuilder.setSurname(surname);
                int indexMiddleName = line.indexOf("|", indexSurname + 1);
                String middleName = line.substring(indexSurname + 1, indexMiddleName);
                patientBuilder.setMiddleName(middleName);
                String yearOfBirth = line.substring(indexMiddleName + 1, line.length());
                patientBuilder.setYearOfBirth(Integer.parseInt(yearOfBirth));
                patientDataStore.addPatient(patientBuilder.build());
            }
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("Пациенты из файла: ");
        printPatient(patientDataStore);
        int countPatient;
        try {
            countPatient = askCountPatient();
        } catch (MyException ex) {
            System.out.println(ex.getRussianMessage());
            return;
        }
        Scanner inputScanner = new Scanner(System.in);
        for (int i = 0; i < countPatient; i++) {
            PatientBuilder patientBuilder = new PatientBuilder();
            System.out.println("Введите имя пациента:");
            String name = inputScanner.next();
            patientBuilder.setName(name);
            System.out.println("Введите фамилию пациента:");
            String surname = inputScanner.next();
            patientBuilder.setSurname(surname);
            System.out.println("Введите отчество пациента:");
            String middleName = inputScanner.next();
            patientBuilder.setMiddleName(middleName + " ");
            System.out.println("Введите год рождения пациента:");
            int yearOfBirth = inputScanner.nextInt();
            patientBuilder.setYearOfBirth(yearOfBirth);
            patientDataStore.addPatient(patientBuilder.build());
        }
        writeToFile(file, patientDataStore);
        System.out.println("Все пациенты: ");
        printPatient(patientDataStore);
        printPatientSearch(patientDataStore);
    }

    private static void writeToFile(File file, PatientDataStore patientDataStore) {
        try {
            FileWriter writer = new FileWriter(file, true);
            for (Patient patient : patientDataStore.getAllPatients()) {
                writer.write(patient.getName() + "|" + patient.getSurname() + "|"
                        + patient.getMiddleName() + "|" + patient.getYearOfBirth() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int askCountPatient() throws MyException {
        System.out.println("Введите количество пациентов: ");
        Scanner inputScanner = new Scanner(System.in);
        int countPatient = inputScanner.nextInt();
        if (countPatient <= 0) {
            throw new MyException("\n Вы неправильно набрили количество пациентов");
        }
        return countPatient;
    }

    private static void printPatientSearch(PatientDataStore patientDataStore) {
        PatientSearchParametersBuilder parametersBuilder = new PatientSearchParametersBuilder();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Введите имя пациента: ");
        parametersBuilder.setName(inputScanner.next());
        System.out.println("Введите фамилию пациента: ");
        parametersBuilder.setSurname(inputScanner.next());
        System.out.println("Введите год рождения пациента: ");
        parametersBuilder.setYearOfBirth(inputScanner.nextInt());
        for (Patient patient : patientDataStore.getAllPatients())
            if (patient.isMatchSearchParameters(parametersBuilder.build())) {
                System.out.println("Пациент " + patient.getName() + " " + patient.getSurname() + " "
                        + patient.getMiddleName() + " возраст = " + patient.getAge());
            } else {
                System.out.println("Пациент отсутствует в базе данных");
            }
    }

    private static void printPatient(PatientDataStore patientDataStore) {
        for (Patient patient : patientDataStore.getAllPatients()) {
            System.out.println("Пациент " + patient.getName() + " " + patient.getSurname() + " "
                    + patient.getMiddleName() + " возраст = " + patient.getAge());
        }
    }
}