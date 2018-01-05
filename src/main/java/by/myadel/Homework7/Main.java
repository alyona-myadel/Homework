package by.myadel.Homework7;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    private static final long oneYearSeconds = 31536000L;
    private static final long oneMonthSeconds = 2592000L;
    private static final long oneDaySeconds = 86400L;
    private static final long oneHourSeconds = 3600L;
    private static final long oneMinuteSeconds = 60L;

    public static void main(String[] args) throws ParseException {
        int countStudents = askCountStudents();
        if (countStudents <= 0) {
            System.out.println("Вы неправильно набрили количество студентов");
            return;
        }
        StudentsDataStore studentsDataStore = new StudentsDataStore();
        Scanner inputScanner = new Scanner(System.in);
        for (int i = 0; i < countStudents; ++i) {
            StudentBuilder studentBuilder = new StudentBuilder();
            System.out.println("Введите имя студента:");
            studentBuilder.setName(inputScanner.next());
            System.out.println("Введите фамилию студента:");
            studentBuilder.setSurname(inputScanner.next());
            System.out.println("Введите дату рождения студента, \nв формате \"01.01.1995\":");
            String date = inputScanner.next();
            studentBuilder.setDateOfBirth(date);
            studentsDataStore.addStudent(studentBuilder.build());
        }
        long summAgeStudents = 0;
        for (Student student : studentsDataStore.getAllPatients()) {
            student.printStudents();
            summAgeStudents = summAgeStudents + student.calculateAgeSeconds();
        }
        long averageAgeStudents = summAgeStudents / countStudents;
        System.out.println("Средний возраст студентов: ");
        printAge(averageAgeStudents);
    }

    private static int askCountStudents() {
        System.out.println("Введите количество студентов: ");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }

    private static void printAge(long ageSeconds) {
        long year = ageSeconds / oneYearSeconds;
        long remainder = ageSeconds % oneYearSeconds;
        long month = remainder / oneMonthSeconds;
        remainder %= oneMonthSeconds;
        long day = remainder / oneDaySeconds;
        remainder %= oneDaySeconds;
        long hour = remainder / oneHourSeconds;
        remainder %= oneHourSeconds;
        long minute = remainder / oneMinuteSeconds;
        long seconds = remainder % oneMinuteSeconds;
        System.out.println(year + " год " + month + " месяцев " + day + " дней " + hour + " часов "
                + minute + " минут " + seconds + " секунд");
    }

}
