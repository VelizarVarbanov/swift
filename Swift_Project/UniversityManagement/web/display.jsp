<%@page import="java.time.LocalDateTime"%>
<%@page import="insurance.SocialInsuranceRecord"%>
<%@page import="mysql.MySqlInsuranceStoragem"%>
<%@page import="java.util.LinkedList"%>
<%@page import="education.Education"%>
<%@page import="mysql.MySqlEducationStorage"%>
<%@page import="personaldetails.Citizen"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="mysql.MySqlAddressStorage"%>
<%@page import="mysql.MySqlPersonalStorage"%>
<%@page import="contracts.DALException"%>
<%@page import="address.*"%>
<%@page import="personaldetails.*"%>
<%@page import = "java.sql.*"%>
<%Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Information</title>
    </head>
    <body>
        <a href="userInfo.jsp"><input type="button" value="Home Page" name="home" style="border-radius: 10px;"/></a>

        <%
            MySqlAddressStorage mysqlAddress = new MySqlAddressStorage();
            int id = Integer.parseInt(request.getParameter("id"));
            Address adres = null;
            try {
                adres = mysqlAddress.getaddress(id);
            } catch (DALException ex) {
                System.out.print("OOPs");
            }
            MySqlPersonalStorage mysqlPerson = new MySqlPersonalStorage();
            Citizen citizen = null;
            try {
                citizen = mysqlPerson.getcitizen(id);
            } catch (DALException ex) {
                System.out.print("OOPs");
            }
            MySqlEducationStorage mysqlEducation = new MySqlEducationStorage();
            try {
                LinkedList<Education> education = mysqlEducation.geteducation(id);

        %>

        <%for (Education s : education) {
                if (s.finalGrade == 0.0) {%>
        <table border="1">       
            <tbody>
                <tr>
                    <td>Enrollment Date</td>
                    <td>Graduation Date</td>
                    <td>Institution Name</td>
                    <td>Degree level</td>
                    <td>FInal grade </td>
                </tr>
                <tr>
                    <td><%= s.enrollmentDate%></td>
                    <td><%= s.graduationDate%></td>
                    <td><%= s.institutionName%></td>
                    <td><%= s.getDegreeById(s.degree_id)%></td>
                    <td><%%></td>
                </tr>
            </tbody>
        </table>
        <%} else {%>
        <table border="1">       
            <tbody>
                <tr>
                    <td>Enrollment Date</td>
                    <td>Graduation Date</td>
                    <td>Institution Name</td>
                    <td>Degree level</td>
                    <td>FInal grade </td>
                </tr>
                <tr>
                    <td><%= s.enrollmentDate%></td>
                    <td><%= s.graduationDate%></td>
                    <td><%= s.institutionName%></td>
                    <td><%= s.getDegreeById(s.degree_id)%></td>
                    <td><%= s.finalGrade%></td>
                </tr>
            </tbody>
        </table>
        <%}
                }
            } catch (DALException ex) {
                System.out.print("OOPs");
            }

        %>
        <br/>
        <hr/>
        <table border="1">       
            <tbody>
                <tr>
                    <td>First Name</td>
                    <td>Middle Name</td>
                    <td>Last Name</td>
                    <td>gender</td>
                    <td>Height</td>
                    <td>Date of birth</td>
                    <td>Country</td>
                    <td>City</td>
                    <td>municipality</td>
                    <td>postalcode</td>
                    <td>street</td>
                    <td>number</td>
                    <td>floor</td>
                    <td>apartment</td>
                </tr>
                <tr>
                    <td><%= citizen._firstName%></td>
                    <td><%= citizen._middleName%></td>
                    <td><%= citizen._lastName%></td>
                    <td><%= citizen._gender%></td>
                    <td><%= citizen._height%></td>
                    <td><%= citizen._dateOfBirth%></td>
                    <td><%= adres.country%></td>
                    <td><%= adres.city%></td>
                    <td><%= adres.municipality%></td>
                    <td><%= adres.postalCode%></td>
                    <td><%= adres.street%></td>
                    <td><%= adres.number%></td>
                    <%if (adres.floor != 0.0) {%>
                    <td><%= adres.floor%></td>
                    <%} else {%>
                    <td><%%></td>
                    <%}%>
                    <%if (adres.apartmentNo != 0.0) {%>
                    <td><%= adres.apartmentNo%></td>
                    <%} else {%>
                    <td><%%></td>
                    <%}%>
                </tr>
            </tbody>
        </table>
        <%LinkedList<Education> education = null;
            MySqlEducationStorage mysqlEducation2 = new MySqlEducationStorage();
            try {
                education = mysqlEducation2.geteducation(id);
            } catch (DALException ex) {
                System.out.print("OOPs");
            }
            MySqlInsuranceStoragem mysqlInsurance = new MySqlInsuranceStoragem();
            LinkedList<SocialInsuranceRecord> insurances = null;
            try {
                insurances = mysqlInsurance.getinsurance(id);
            } catch (DALException ex) {
                System.out.print("OOPs");
            }
            int month = insurances.peek().month;
            LocalDateTime time = LocalDateTime.now();
            if (month + 3 <= time.getMonthValue() && education.size() >= 2) {
        %>
        <br/>
        <table border="1">
            <tbody>
                <tr>
                    <td>Yes</td>

                </tr>
            </tbody>
        </table>
        <%} else {%>
        <br/>
        <table border="1">
            <tbody>
                <tr>
                    <td>No</td>

                </tr>
            </tbody>
        </table>
        <%}%>
    </body>
</html>
