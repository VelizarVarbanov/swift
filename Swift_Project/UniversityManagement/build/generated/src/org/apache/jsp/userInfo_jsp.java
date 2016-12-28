package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import contracts.DALException;
import address.*;
import java.sql.*;

public final class userInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User Information</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <a href=\"newEducation.jsp\"><input type=\"button\" value=\"New Education\" name=\"education\" style=\"border-radius: 10px;\" /></a> \n");
      out.write("        <a href=\"newSocialInsuranceRecord.jsp\"><input type=\"button\" value=\"New Insurance\" name=\"insurance\" style=\"border-radius: 10px;\"/></a>\n");
      out.write("       \n");
      out.write("       <hr/>\n");
      out.write("       <form name=\"myForm\" action=\"display.jsp\" method=\"POST\">\n");
      out.write("           <table border=\"1\">               \n");
      out.write("               <tbody>\n");
      out.write("                   <tr>\n");
      out.write("                       <td>Insert ID: </td>\n");
      out.write("                       <td><input type=\"text\" name=\"id\" value=\"\" size=\"55\" /></td>\n");
      out.write("                   </tr>\n");
      out.write("               </tbody>\n");
      out.write("           </table>\n");
      out.write("       <input type=\"submit\" value=\"Submit\" name=\"submit\" style=\"border-radius: 5px;\"/>\n");
      out.write("       </form>\n");
      out.write("       <br/>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
