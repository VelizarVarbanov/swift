package dataAccessLayer;


import java.sql.*;

public class MySqlAddressStorage {
    final String DBMS_CONN_STRING = "jdbc:mysql://127.0.0.1:3306/school";

    final String DBMS_USERNAME = "root";

    final String DBMS_PASSWORD = "Velizar90";

    public void getAddress(int id) throws DALException {
        String sqlStatement = "SELECT country, city, manucipality, postal_code, street, number, floor, apartmentNo FROM addresses WHERE id = ?";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String country = rs.getString("country");
                String city = rs.getString("city");
                String manucipality = rs.getString("manucipality");
                String postal_code = rs.getString("postal_code");
                String street = rs.getString("street");
                String number = rs.getString("number");
                int floor = rs.getInt("floor");
                int apartmentNo = rs.getInt("apartmentNo");
                System.out.format("%s,%s,%s,%s,%s,%s,%d,%d\n", country, city, manucipality, postal_code, street, number, floor, apartmentNo);
            }

        } catch (SQLException ex) {

            while (ex != null) {

                System.out.println(ex.getSQLState());

                System.out.println(ex.getMessage());

                System.out.println(ex.getErrorCode());

                ex = ex.getNextException();

            }

        }
    }

    public void insertAddress(Address address) throws DALException{
        String sqlStatement = "INSERT into addresses"
                + "(country, city, manucipality, postal_code, street, number, floor, apartmentNo)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setString(1, address.country);
            statement.setString(2, address.city);
            statement.setString(3, address.manucipality);
            statement.setString(4, address.postal_code);
            statement.setString(5, address.street);
            statement.setString(6, address.number);
            statement.setInt(7, address.floor);
            statement.setInt(8, address.apartmentNo);
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
}
