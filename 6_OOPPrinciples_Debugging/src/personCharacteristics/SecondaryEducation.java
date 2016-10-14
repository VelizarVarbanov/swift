package personCharacteristics;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class SecondaryEducation {

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {

        this.enrollmentDate = enrollmentDate;
    }
    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    static boolean graduated;
    String enrollmentDate;
    String graduationDate;
    String institutionName;
    String finalGrade;
//;SOU Geo Milev;20.9.2007;20.5.2012;4.14
    public SecondaryEducation(String institutionName, String enrollmentDate, String graduationDate, String finalGrade){
        this.institutionName = institutionName;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
        this.finalGrade = finalGrade;
    }
    public SecondaryEducation(String institutionName, String enrollmentDate, String graduationDate) {
        this(institutionName, enrollmentDate, graduationDate,null);
    }
    public String getEnrollFormat() {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate enroll = LocalDate.parse(enrollmentDate, inputFormat);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String enrollFormattedDate = formatter.format(enroll);
        return enrollFormattedDate;

    }

    public String getGrFormat() {
        DateTimeFormatter graduatedFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate graduated = LocalDate.parse(graduationDate, graduatedFormat);
        DateTimeFormatter grFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String grFormatted = grFormatter.format(graduated);
        return grFormatted;
    }
}
