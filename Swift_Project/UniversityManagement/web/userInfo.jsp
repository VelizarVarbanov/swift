<%@page import="contracts.DALException"%>
<%@page import="address.*"%>
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
        <a href="newEducation.jsp"><input type="button" value="New Education" name="education" style="border-radius: 10px;" /></a> 
        <a href="newSocialInsuranceRecord.jsp"><input type="button" value="New Insurance" name="insurance" style="border-radius: 10px;"/></a>
       
       <hr/>
       <form name="myForm" action="display.jsp" method="POST">
           <table border="1">               
               <tbody>
                   <tr>
                       <td>Insert ID: </td>
                       <td><input type="text" name="id" value="" size="55" /></td>
                   </tr>
               </tbody>
           </table>
       <input type="submit" value="Submit" name="submit" style="border-radius: 5px;"/>
       </form>
       <br/>
    </body>
</html>
