package mysql;
import address.Address;
import contracts.AddressStorage;
import contracts.DALException;
import java.sql.*;

public class MySqlAddressStorage implements AddressStorage {
    final String DBMS_CONN_STRING = "jdbc:mysql://127.0.0.1:3306/citizens";

    final String DBMS_USERNAME = "root";

    final String DBMS_PASSWORD = "Velizar90";
    public int addresses_id;
    
     @Override
    public void insertaddress(Address address) throws DALException {
  
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
            CallableStatement statement = con.prepareCall("{CALL insert_address(?, ?, ?, ?, ?, ?, ?, ?, ?)}")) {
            statement.registerOutParameter("addresses_id", Types.INTEGER);
            statement.setString(1, address.country);
            statement.setString(2, address.city);
            statement.setString(3, address.municipality);
            statement.setString(4, address.postalCode);
            statement.setString(5, address.street);
            statement.setString(6, address.number);
            statement.setInt(7, address.floor);
            statement.setInt(8, address.apartmentNo);
            //statement.setInt("addresses_id", 1);
            boolean hadResults = statement.execute();
            while (hadResults) {
            ResultSet rs = statement.getResultSet();
             hadResults = statement.getMoreResults();
            }
            addresses_id = statement.getInt("addresses_id");
        } catch (SQLException ex) {

            while (ex != null) {

                System.out.println(ex.getSQLState());

                System.out.println(ex.getMessage());

                System.out.println(ex.getErrorCode());

                ex = ex.getNextException();

            }
        }
    }  
    
    public void trancateTable() throws DALException {
    String sqlStatement = "truncate address; ";
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             CallableStatement statement = con.prepareCall(sqlStatement)) {
            statement.execute();
            } catch (SQLException ex) {

            while (ex != null) {

                System.out.println(ex.getSQLState());

                System.out.println(ex.getMessage());

                System.out.println(ex.getErrorCode());

                ex = ex.getNextException();

            }
        }
    }

    @Override
    public Address getaddress(int id) throws DALException {
    final String DBMS_CONN_STRING = "jdbc:mysql://127.0.0.1:3306/citizens";

    final String DBMS_USERNAME = "root";

    final String DBMS_PASSWORD = "Velizar90";

    Address address = null;
    
    String sqlStatement = "SELECT a.country, a.city, a.municipality, a.street, a.postalCode, a.number, a.floor, a.ApartmentNo"
            +" FROM citizens.address a, citizens.personal_details p"
            +  " WHERE p.person_id = ? "
            + "AND p.addresses_id = a.addresses_id";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String country = rs.getString("a.country");
                String city = rs.getString("a.city");
                String municipality = rs.getString("a.municipality");
                String postalCode = rs.getString("a.postalCode");
                String street = rs.getString("a.street");
                String number = rs.getString("a.number");
                int floor = rs.getInt("a.floor");
                int ApartmentNo = rs.getInt("a.ApartmentNo");
                address = new Address(country, city, municipality, postalCode, street, number, floor, ApartmentNo);
            }
            
        } catch (SQLException ex) {

            while (ex != null) {

                System.out.println(ex.getSQLState());

                System.out.println(ex.getMessage());

                System.out.println(ex.getErrorCode());

                ex = ex.getNextException();

            }

        }
        return address;
    }

   }
