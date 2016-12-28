package education;

import java.time.LocalDate;

public abstract class GradedEducation extends Education{
    float finalGrade;

    public GradedEducation(String institution, LocalDate enrollmentDate, LocalDate graduationDate) {
        super(institution, enrollmentDate, graduationDate);
    }
    
    public float getFinalGrade(){
        if(isGraduated()){
            return finalGrade;    
        }
        
        throw new IllegalStateException("No final grade can be provided before graduation.");
    }
    
    public void gotGraduated(float finalGrade){
        
        if( ! ( 2 <= finalGrade && finalGrade <= 6) ) {
            throw new IllegalArgumentException("Graduation grade is expected to be between 2 and 6.");
        }
        
        gotGraduated();
        
        this.finalGrade = finalGrade;
    }
}
