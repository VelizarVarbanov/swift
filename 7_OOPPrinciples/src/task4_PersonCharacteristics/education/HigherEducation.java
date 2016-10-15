package task4_PersonCharacteristics.education;

import task4_PersonCharacteristics.Person;
import task4_PersonCharacteristics.PersonCharacteristics;

public class HigherEducation extends GradedEducation {

    public HigherEducation(String graduated, String enrollmentDate, String graduationDate, String institutionName, float finalGrade) {
        super(graduated, enrollmentDate, graduationDate, institutionName, finalGrade);
    }

    public HigherEducation(String graduated, String enrollmentDate, String graduationDate, String institutionName) {
        super(graduated, enrollmentDate, graduationDate, institutionName, 0.0f);
    }

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
        String codeEducation="";

        if (PersonCharacteristics.code.equals("B")) codeEducation = "bachelor";
        else if (PersonCharacteristics.code.equals("M")) codeEducation = "master";
        else if (PersonCharacteristics.code.equals("D")) codeEducation = "doctorate";
        if (Education.graduated.equals("true")) {
            result += String.format(" %s started %s degree in %s on %s and finished ", hisOrHer, codeEducation, institutionName, Education.getEnrollFormat());
            result += String.format("on %s. %s grade was %.3f", Education.getGrFormat(), hisOrHer, GradedEducation.finalGrade);
        } else if (Education.graduated.equals("false")) {

            result += String.format(" %s started %s degree in  %s on %s and is supposed to graduate ", heOrShe, codeEducation,institutionName, Education.getEnrollFormat());
            result += String.format("on %s.", Education.getGrFormat());
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
        return null;
    }

    @Override
    public String getGraduationDate(String graduationDate) {
        return null;
    }

    @Override
    public String getInstitutionName(String institutionName) {
        return null;
    }
}
