
package mysql;

import contracts.DALException;
import contracts.PersonalStorage;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import personaldetails.Citizen;
import personaldetails.Gender;

public class MySqlPersonalStorage implements PersonalStorage{
    final String DBMS_CONN_STRING = "jdbc:mysql://127.0.0.1:3306/citizens";
    final String DBMS_USERNAME = "root";
    final String DBMS_PASSWORD = "Velizar90";
    public int person_id;
     @Override
    public void insertCitizen(Citizen citizen, int address_id) throws DALException {
    String sqlStatement = "CALL insert_personal_details(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
            CallableStatement statement = con.prepareCall(sqlStatement)) {
            statement.registerOutParameter("person_id", Types.INTEGER);
            statement.setString(1, citizen._firstName);
            statement.setString(2, citizen._middleName);
            statement.setString(3, citizen._lastName);
           
            if(citizen._gender == Gender.Male) {
                statement.setString(4, "M");
            } else {
                statement.setString(4, "F");
            }
            statement.setInt(5, citizen._height);
            java.sql.Date date = java.sql.Date.valueOf(citizen._dateOfBirth);
            statement.setDate(6, date);
            statement.setInt(7, address_id);
            statement.setInt("person_id", 1);
            boolean hadResults = statement.execute();
            while (hadResults) {
            ResultSet rs = statement.getResultSet();
             hadResults = statement.getMoreResults();
            }
            person_id = statement.getInt("person_id");

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
    String sqlStatement = "truncate citizens.personal_details; ";
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
    public Citizen getcitizen(int id) throws DALException { 
    final String DBMS_CONN_STRING = "jdbc:mysql://127.0.0.1:3306/citizens";
    final String DBMS_USERNAME = "root";
    final String DBMS_PASSWORD = "Velizar90";
    Citizen citizen = null;
    String sqlStatement = "SELECT first_name, middle_name, last_name, gender, height, date_of_birth " +
"FROM citizens.personal_details WHERE person_id = ?;";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String middleName = rs.getString("middle_name");
                String last_name = rs.getString("last_name");
                Gender gender = null;
                if (rs.getString("gender").equalsIgnoreCase("m")){
                    gender = Gender.Male;
                } else {
                    gender = Gender.Female;
                }
                int height = rs.getInt("height");
                Date birthday = rs.getDate("date_of_birth");
                LocalDate dateOfBirth = birthday.toLocalDate();
               
                
                citizen = new Citizen(firstName, middleName, last_name, gender, height, dateOfBirth);
            }
            
        } catch (SQLException ex) {

            while (ex != null) {

                System.out.println(ex.getSQLState());

                System.out.println(ex.getMessage());

                System.out.println(ex.getErrorCode());

                ex = ex.getNextException();
            }
        }
        return citizen;
    }
}   
