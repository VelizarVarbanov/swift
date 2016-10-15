package task4_PersonCharacteristics.education;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Education {
   // Peter;Petrov;M;184;9.9.1985;S;SOU Pushkin;15.9.2000;20.5.2005;5.11
   // Ivan;Ivanov;M;177;29.2.2000;S;SOU Chintulov;16.9.2015;22.5.2020
    public static String graduated;
    public static String enrollmentDate;
    public static String graduationDate;
    public static String institutionName;

    public Education(String graduated, String enrollmentDate, String graduationDate, String institutionName) {
        this.graduated = graduated;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
        this.institutionName = institutionName;

    }

    public static String getGraduated() {
        return graduated;
    }

    public static void setGraduated(String graduated) {
        Education.graduated = graduated;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public abstract void getDegree();
    public abstract void  gotGraduated();

    public abstract void isGraduated();
    public abstract String getEnrollmentDate(String enrollmentDate);
    public abstract String getGraduationDate(String graduationDate);
    public abstract String getInstitutionName(String institutionName);

    public static String getEnrollFormat() {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate enroll = LocalDate.parse(enrollmentDate, inputFormat);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String enrollFormattedDate = formatter.format(enroll);
        return enrollFormattedDate;
    }

    public static String getGrFormat() {
        DateTimeFormatter graduatedFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate graduated = LocalDate.parse(graduationDate, graduatedFormat);
        DateTimeFormatter grFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String grFormatted = grFormatter.format(graduated);
        return grFormatted;
    }



}
