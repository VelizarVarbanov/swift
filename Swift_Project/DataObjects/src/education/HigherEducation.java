package education;

import java.time.LocalDate;

public class HigherEducation extends GradedEducation{

    EducationDegree degree;
    
    public HigherEducation(String institution, LocalDate enrollmentDate, LocalDate graduationDate, EducationDegree degree) {
        super(institution, enrollmentDate, graduationDate);
        
        if(degree != EducationDegree.Master 
                && degree != EducationDegree.Bachelor 
                && degree != EducationDegree.Doctorate) {
            throw new IllegalArgumentException("Expected Bachelor, Master or Doctorate as degree.");
        }
        
        this.degree = degree;
    }

    @Override
    public String getDegreeById(int id) {
        return "";
    }
}
