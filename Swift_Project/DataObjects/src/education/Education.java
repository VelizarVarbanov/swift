package education;

import java.time.LocalDate;

public abstract class Education{

    boolean graduated;
    public final LocalDate enrollmentDate;
    public LocalDate graduationDate;
    public final String institutionName;
    public int degree_id;
    public int person_id;
    public float finalGrade;

    public abstract String getDegreeById(int id); 

    public Education(String institution, LocalDate enrollmentDate, LocalDate graduationDate) {
        this.institutionName = institution;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
    }
    public Education(String institution, LocalDate enrollmentDate, LocalDate graduationDate, int degree_id, int person_id, float finalGrade) {
        this.institutionName = institution;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
        this.degree_id = degree_id;
        this.person_id = person_id;
        this.finalGrade = finalGrade;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        if (graduationDate == null || graduationDate.isBefore(enrollmentDate)) {
            throw new IllegalArgumentException("Graduation date is expected to be after enrollment date.");
        }
        this.graduationDate = graduationDate;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    void gotGraduated() {
        if (graduationDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Graduation date is expected to be a date in the past.");
        }

        graduated = true;
    }
}
