package contracts;
import address.*;
public interface AddressStorage {
    Address getaddress(int id) throws DALException;
    void insertaddress(Address address)throws DALException;
}
