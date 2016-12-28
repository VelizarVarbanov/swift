package mysql;

import contracts.DALException;
import contracts.InsuranceStorage;
import insurance.SocialInsuranceRecord;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class MySqlInsuranceStoragem implements InsuranceStorage {

    final String DBMS_CONN_STRING = "jdbc:mysql://127.0.0.1:3306/citizens";
    final String DBMS_USERNAME = "root";
    final String DBMS_PASSWORD = "Velizar90";

    @Override
    public void insertInsurance(SocialInsuranceRecord insurance, int person_id) throws DALException {
        String sqlStatement = "CALL insert_social_insurance(?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                CallableStatement statement = con.prepareCall(sqlStatement)) {
            statement.setInt(1, insurance.year);
            statement.setInt(2, insurance.month);
            statement.setDouble(3, insurance.amount);
            statement.setInt(4, person_id);
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

    public void trancateTable() throws DALException {
        String sqlStatement = "truncate citizens.social_insurance_record; ";
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
    public LinkedList<SocialInsuranceRecord> getinsurance(int id) throws DALException {
        final String DBMS_CONN_STRING = "jdbc:mysql://127.0.0.1:3306/citizens";

        final String DBMS_USERNAME = "root";

        final String DBMS_PASSWORD = "Velizar90";
        SocialInsuranceRecord insurance = null;
        LinkedList<SocialInsuranceRecord> listInsurance = new LinkedList<SocialInsuranceRecord>();
        String sqlStatement = "SELECT year, month, amount FROM citizens.social_insurance_record WHERE person_id = ?;";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int year = rs.getInt("year");
                int month = rs.getInt("month");
                double amount = rs.getDouble("amount");
                insurance = new SocialInsuranceRecord(year, month, amount);
                listInsurance.add(insurance);
            }

        } catch (SQLException ex) {

            while (ex != null) {

                System.out.println(ex.getSQLState());

                System.out.println(ex.getMessage());

                System.out.println(ex.getErrorCode());

                ex = ex.getNextException();
            }
        }
        return listInsurance;
    }
}
