package task1_School;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlSchoolData {

    final String DBMS_CONN_STRING = "jdbc:mysql://127.0.0.1:3306/school";

    final String DBMS_USERNAME = "root";

    final String DBMS_PASSWORD = "Velizar90";

    public void insertTeacher(String name, String email, double salary) {

        String sqlStatement = "INSERT into teachers"
                + "(name, email, salary)"
                + "VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setDouble(3, salary);
            statement.execute();

        } catch (SQLException ex) {

            // SQLException is actually a linked list of Exceptions
            while (ex != null) {

                System.out.println(ex.getSQLState());

                System.out.println(ex.getMessage());

                System.out.println(ex.getErrorCode());

                ex = ex.getNextException();

            }
        }
    }

    public void getTeacher(int id) {

        String sqlStatement = "SELECT name FROM teachers WHERE id = ?";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("name");

                // print the results
                System.out.format("%s\n", firstName);
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

    public void getTeachers(int bottom, int top) {

        String sqlStatement = "SELECT name FROM teachers WHERE salary > ? AND salary < ?";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setInt(1, bottom);
            statement.setInt(2, top);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("name");

                // print the results
                System.out.format("%s\n", firstName);
            }

        } catch (SQLException ex) {

            // SQLException is actually a linked list of Exceptions
            while (ex != null) {

                System.out.println(ex.getSQLState());

                System.out.println(ex.getMessage());

                System.out.println(ex.getErrorCode());

                ex = ex.getNextException();
            }
        }
    }

    public void insertStudent(String name, String enrollment) {

        String sqlStatement = "INSERT into students"
                + "(name, enrollmentDate)"
                + "VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setString(1, name);
            statement.setString(2, enrollment);
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

    public void getStudent(int id) {

        String sqlStatement = "SELECT name FROM students WHERE id = ?";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("name");

                // print the results
                System.out.format("%s\n", firstName);
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

    public void getStudents(String date) {

        String sqlStatement = "SELECT name FROM students WHERE enrollmentDate > ?";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setString(1, date);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("name");

                // print the results
                System.out.format("%s\n", firstName);
            }

        } catch (SQLException ex) {

            // SQLException is actually a linked list of Exceptions
            while (ex != null) {

                System.out.println(ex.getSQLState());

                System.out.println(ex.getMessage());

                System.out.println(ex.getErrorCode());

                ex = ex.getNextException();
            }
        }
    }

    public void getTeachersAndDisciplines(int id) {

        String sqlStatement = "SELECT disciplines.name FROM school.disciplines\n"
                + "JOIN disciplines_taught AS rel\n"
                + "ON disciplines.id = rel.discipline_id\n"
                + "JOIN teachers\n"
                + "ON rel.teacher_id = teachers.id\n"
                + "WHERE teachers.id = ?";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");

                // print the results
                System.out.format("%s\n", name);
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

    public void getDisciplinesAndTeachers(String name) {

        String sqlStatement = "SELECT teachers.name FROM school.teachers\n"
                + "JOIN disciplines_taught AS rel\n"
                + "ON teachers.id = rel.teacher_id\n"
                + "JOIN disciplines\n"
                + "ON rel.discipline_id = disciplines.id\n"
                + "WHERE disciplines.name = ?";

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
             PreparedStatement statement = con.prepareStatement(sqlStatement)) {
            statement.setString(1, name);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String nameTeacher = rs.getString("name");

                // print the results
                System.out.format("%s\n", nameTeacher);
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
}

