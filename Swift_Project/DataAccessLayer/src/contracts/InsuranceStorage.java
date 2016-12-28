package contracts;
import insurance.*;
import java.util.LinkedList;
public interface InsuranceStorage {
   LinkedList<SocialInsuranceRecord> getinsurance(int id) throws DALException;
   void insertInsurance(SocialInsuranceRecord insurance, int person_id)throws DALException;
}
