package task4_PersonCharacteristics.education;

import task4_PersonCharacteristics.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SecondaryEducation extends GradedEducation{
    public SecondaryEducation(String graduated, String enrollmentDate, String graduationDate, String institutionName, float finalGrade) {
        super(graduated, enrollmentDate, graduationDate, institutionName, finalGrade);
    }
    public SecondaryEducation(String graduated, String enrollmentDate, String graduationDate, String institutionName) {
        super(graduated, enrollmentDate, graduationDate, institutionName, 0.0f);
    }
    public static float finalGrade;

    public static String getInfo() {

        String heOrShe;
        String hisOrHer;
        String result;

        if (Person.gender.equals("M")) {
            heOrShe = "He";
            hisOrHer = "His";
        } else {
            heOrShe = "She";
            hisOrHer = "Her";
        }
        result = String.format("%s %s is %d years old.", Person.firstName, Person.lastName, Person.getAge());
        result += String.format(" %s was born in %d.", heOrShe, Person.formatDob(Person.dob).getYear());

        if (Education.graduated.equals("true")) {
            result += String.format(" %s started secondary degree in %s on %s and finished ", hisOrHer, institutionName, Education.getEnrollFormat());
            result += String.format("on %s. %s grade was %.3f", Education.getGrFormat(), hisOrHer,GradedEducation.finalGrade);
        }

        else if (Education.graduated.equals("false")) {

            result += String.format(" %s started secondary degree in  %s on %s and is supposed to graduate ", heOrShe, institutionName, Education.getEnrollFormat());
            result += String.format("on %s.", Education.getGrFormat());
            result += String.format(" %s %s is under-aged.", Person.firstName, Person.lastName);
        }
        return result;
    }
    @Override
    public void getDegree() {

    }

    @Override
    public void gotGraduated() {

    }

    @Override
    public void isGraduated() {

    }

    @Override
    public String getEnrollmentDate(String enrollmentDate) {
        return this.enrollmentDate;
    }

    @Override
    public String getGraduationDate(String graduationDate) {
        return this.graduationDate;
    }

    @Override
    public String getInstitutionName(String institutionName) {
        return this.institutionName;
    }
}
