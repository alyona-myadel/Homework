package by.myadel.Homework7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Student {
    private String name;
    private String surname;
    private Date dateOfBirth;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date docDate = format.parse(dateOfBirth);
        this.dateOfBirth = docDate;
    }

    public String printDate() {
        SimpleDateFormat formatForDate = new SimpleDateFormat("dd.MM.yyyy'г.'");
        return formatForDate.format(getDateOfBirth());
    }

    public void printStudents() {
        System.out.println("Студент " + getName() + " " + getSurname() + " дата рождения: " + printDate());
    }

    public long calculateAgeSeconds() {
        Calendar birthday = Calendar.getInstance();
        Calendar nowDay = Calendar.getInstance();
        birthday.setTime(getDateOfBirth());
        return (nowDay.getTimeInMillis() - birthday.getTimeInMillis()) / 1000;
    }


}
