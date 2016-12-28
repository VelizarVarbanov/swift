package contracts;
import education.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public interface EducationStorage {
    void insertDegree(String degree) throws DALException;
    void insertEducation(Education education, int person_id) throws DALException;
    void insertEducation(GradedEducation gradedEducation, int person_id) throws DALException;
    LinkedList<Education> geteducation(int id) throws DALException;
    
}
