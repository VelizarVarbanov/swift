package mysql;

import contracts.DALException;
import contracts.EducationStorage;
import java.sql.*;
import education.Education;
import education.EducationDegree;
import education.GradedEducation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.LinkedList;

public class MySqlEducationStorage implements EducationStorage {

    final String DBMS_CONN_STRING = "jdbc:mysql://127.0.0.1:3306/citizens";
    final String DBMS_USERNAME = "root";
    final String DBMS_PASSWORD = "Velizar90";
    public int degree_id;

    @Override
    public void insertDegree(String degree) throws DALException {
        String sqlStatement = "CALL insert_degree(?,?)";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                CallableStatement statement = con.prepareCall(sqlStatement)) {
            statement.registerOutParameter("degree_id", Types.INTEGER);
            if (degree.equalsIgnoreCase("p")) {
                statement.setString(1, "Primary");
            } else if (degree.equalsIgnoreCase("s")) {
                statement.setString(1, "Secondary");
            } else if (degree.equalsIgnoreCase("b")) {
                statement.setString(1, "Bachelor");
            } else if (degree.equalsIgnoreCase("m")) {
                statement.setString(1, "Master");
            } else if (degree.equalsIgnoreCase("d")) {
                statement.setString(1, "Doctorate");
            }
            statement.setInt("degree_id", 1);
            boolean hadResults = statement.execute();
            while (hadResults) {
                ResultSet rs = statement.getResultSet();
                hadResults = statement.getMoreResults();
            }
            degree_id = statement.getInt("degree_id");
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
    public void insertEducation(Education education, int person_id) throws DALException {
        String sqlStatement = "CALL insert_education(?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                CallableStatement statement = con.prepareCall(sqlStatement)) {
            java.sql.Date date = java.sql.Date.valueOf(education.enrollmentDate);
            statement.setDate(1, date);
            java.sql.Date dateGrad = java.sql.Date.valueOf(education.graduationDate);
            statement.setDate(2, dateGrad);
            statement.setBoolean(3, education.isGraduated());
            statement.setString(4, education.institutionName);
            statement.setDouble(5, 0.0);
            statement.setInt(6, person_id);
            statement.setInt(7, degree_id);
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
    public void insertEducation(GradedEducation gradedEducation, int person_id) throws DALException {
        String sqlStatement = "CALL insert_education(?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                CallableStatement statement = con.prepareCall(sqlStatement)) {
            java.sql.Date date = java.sql.Date.valueOf(gradedEducation.enrollmentDate);
            statement.setDate(1, date);
            java.sql.Date dateGrad = java.sql.Date.valueOf(gradedEducation.graduationDate);
            statement.setDate(2, dateGrad);
            statement.setBoolean(3, gradedEducation.isGraduated());
            statement.setString(4, gradedEducation.institutionName);
            if (!gradedEducation.graduationDate.isAfter(LocalDate.now())) {
                statement.setDouble(5, gradedEducation.getFinalGrade());
            } else {
                statement.setDouble(5, 0);
            }
            statement.setInt(6, person_id);
            statement.setInt(7, degree_id);
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
        String sqlStatement = "truncate citizens.degree;";
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

    public void trancateTableEducation() throws DALException {
        String sqlStatement = "truncate citizens.education; ";

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

    public String getDegreeById(int id) {
        String degree = "";
        String sqlStatement = "SELECT degree FROM citizens.degree WHERE degree_id = ?;";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                degree = rs.getString("degree");
            }
        } catch (SQLException ex) {

            while (ex != null) {

                System.out.println(ex.getSQLState());

                System.out.println(ex.getMessage());

                System.out.println(ex.getErrorCode());

                ex = ex.getNextException();
            }
        }
        return degree;
    }

    @Override
    public LinkedList<Education> geteducation(int id) throws DALException {
        Education education = null;
        LinkedList<Education> listEducation = new LinkedList<Education>();
        String sqlStatement = "SELECT enrollment_date, graduation_date, graduated, institution_name, finalGrade, person_id, degree_id  FROM citizens.education WHERE person_id = ?";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Date enrollmentDate = rs.getDate("enrollment_date");
                LocalDate enrollment_date = enrollmentDate.toLocalDate();
                Date graduationDate = rs.getDate("graduation_date");
                LocalDate graduation_date = graduationDate.toLocalDate();
                boolean graduated = rs.getBoolean("graduated");
                String institution_name = rs.getString("institution_name");
                float finalGrade = rs.getFloat("finalGrade");
                int degree_id = rs.getInt("degree_id");
                int person_id = rs.getInt("person_id");

                education = new Education(institution_name, enrollment_date, graduation_date, degree_id, person_id, finalGrade) {
                    @Override
                    public String getDegreeById(int id) {
                        String degree = "";
                        String sqlStatement = "SELECT degree FROM citizens.degree WHERE degree_id = ?;";

                        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                                PreparedStatement statement = con.prepareStatement(sqlStatement)) {
                            statement.setInt(1, id);

                            ResultSet rs = statement.executeQuery();

                            while (rs.next()) {
                                degree = rs.getString("degree");
                            }
                        } catch (SQLException ex) {

                            while (ex != null) {

                                System.out.println(ex.getSQLState());

                                System.out.println(ex.getMessage());

                                System.out.println(ex.getErrorCode());

                                ex = ex.getNextException();
                            }
                        }
                        return degree;
                    }
                };
                listEducation.add(education);
            }

        } catch (SQLException ex) {

            while (ex != null) {

                System.out.println(ex.getSQLState());

                System.out.println(ex.getMessage());

                System.out.println(ex.getErrorCode());

                ex = ex.getNextException();
            }
        }
        return listEducation;
    }

}
