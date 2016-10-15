package task4_PersonCharacteristics.education;

public abstract class GradedEducation extends Education{
    public static float finalGrade;

    public GradedEducation(String graduated, String enrollmentDate, String graduationDate, String institutionName, float finalGrade) {
        super(graduated, enrollmentDate, graduationDate, institutionName);
        this.finalGrade = finalGrade;

    }

    public void setFinalGrade(float finalGrade) {
        this.finalGrade = finalGrade;
    }


    float gotGraduated(float finalGrade) {

        return finalGrade;
    }
    public float getFinalGrade() {

        return finalGrade;
    }

}
