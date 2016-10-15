package task4_PersonCharacteristics;
import task4_PersonCharacteristics.education.SecondaryEducation;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Person {

    public static String firstName;
    public static String lastName;
    public static String dob;
    public static String gender;

    Person(String firstName, String lastName, String gender, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;


    }

    public static LocalDate formatDob(String dob) {
        Person.dob = dob;
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate inputDate = LocalDate.parse(dob, inputFormat);
        return inputDate;
    }


    public static short getAge() {
        return (short) (Year.now().getValue() - formatDob(Person.dob).getYear());
    }


    boolean isUnderAged() {
        return getAge() < 18;
    }

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    int getYearBorn() {
        return formatDob(this.dob).getYear();
    }
}
