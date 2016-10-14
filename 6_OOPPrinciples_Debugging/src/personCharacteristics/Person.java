package personCharacteristics;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Person {
    static short gradesCount = 4;

    String firstName;
    String lastName;
    String dob;
    String gender;
    short height;
    double finalGrade;
    SecondaryEducation secondary;
//Peter;Petrov;M;184;9.9.1985;SOU Pushkin;15.9.2000;20.5.2005;5.11
//        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
//        inputDate = LocalDate.parse(dob, inputFormat);


    Person(String firstName, String lastName, String gender, short height, String dob, SecondaryEducation secondary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.height = height;
        this.dob = dob;
        this.secondary = secondary;

    }
    public LocalDate formatDob(String dob){
        this.dob = dob;
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate inputDate = LocalDate.parse(dob, inputFormat);
        return inputDate;
    }


    short getAge() {
        return (short) (Year.now().getValue() - formatDob(this.dob).getYear());
    }

    String getInfo() {

        String heOrShe;
        String hisOrHer;
        String result;

        if (gender.equals("M")) {
            heOrShe = "He";
            hisOrHer = "His";
        } else {
            heOrShe = "She";
            hisOrHer = "Her";
        }
        result = String.format("%s %s is %d years old.", firstName, lastName, getAge());
        result += String.format(" %s was born in %d.", heOrShe, formatDob(this.dob).getYear());
        if (SecondaryEducation.graduated == true) {

            result += String.format(" %s started %s on %s and finished ", hisOrHer, secondary.institutionName, secondary.getEnrollFormat());
            result += String.format("on %s with a grade of %s", secondary.getGrFormat(), secondary.finalGrade);
            return result;
        }

         else if (SecondaryEducation.graduated == false) {
            result += String.format(" %s started %s on %s and is supposed to graduate ", hisOrHer, secondary.institutionName, secondary.getEnrollFormat());
            result += String.format("on %s", secondary.getGrFormat(), secondary.finalGrade);
            result += String.format(" %s %s is under-aged.", firstName, lastName);
            return result;
        }
        return result;
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

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    short getHeight() {

        return height;
    }

    void setHeight(short newHeight) {
        this.height = newHeight;
    }

}

