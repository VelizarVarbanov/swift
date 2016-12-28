package contracts;
import personaldetails.*;
public interface PersonalStorage {
    void insertCitizen(Citizen insurance, int address_id)throws DALException;
    Citizen getcitizen(int id) throws DALException;
}
