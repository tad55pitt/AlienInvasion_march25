package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.pitt.is1017.spaceinvaders.User;

public final class Registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>AlienInvasion - Registration</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                font-family: candara;\n");
      out.write("                color:white;\n");
      out.write("                background-image: url(http://wallpapercave.com/wp/pEeUsp1.jpg);\n");
      out.write("                background-size: cover;\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            form{\n");
      out.write("                text-align: center;\n");
      out.write("                margin:auto;\n");
      out.write("                background-color: black;\n");
      out.write("                border: 4px solid red;\n");
      out.write("                border-radius: 10px 10px 10px 10px;\n");
      out.write("                width: 700px;\n");
      out.write("                position: relative;\n");
      out.write("            }\n");
      out.write("            .button{\n");
      out.write("                background-color: #FFFFFF;\n");
      out.write("                border-radius: 6px;\n");
      out.write("                font-size: 24px;\n");
      out.write("                width: 140px;\n");
      out.write("                padding: 15px 15px;\n");
      out.write("                text-align: center;\n");
      out.write("                cursor: pointer;\n");
      out.write("                display: inline-block;\n");
      out.write("                box-shadow: 0 2px #999;\n");
      out.write("            }\n");
      out.write("            .button:active {\n");
      out.write("                box-shadow: 0 2px #666;\n");
      out.write("                transform: translateY(2px);\n");
      out.write("            }\n");
      out.write("            .label{\n");
      out.write("                font-size:24px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    ");

        String firstName = "";
        String lastName = "";
        String email = "";
        String password = "";
        String confirmPass = "";
        User user;

        if (request.getParameter("btnRegister") != null) {
            if (request.getParameter("txtFirstName") != null) {
                if (request.getParameter("txtFirstName") != "") {
                    firstName = request.getParameter("txtFirstName");
                }
            }
            if (request.getParameter("txtLastName") != null) {
                if (request.getParameter("txtLastName") != "") {
                    lastName = request.getParameter("txtLastName");
                }
            }
            if (request.getParameter("txtEmail") != null) {
                if (request.getParameter("txtEmail") != "") {
                    email = request.getParameter("txtEmail");
                }
            }
            if (request.getParameter("txtPass") != null) {
                if (request.getParameter("txtPass") != "") {
                    password = request.getParameter("txtPass");
                }
            }
            if (request.getParameter("txtConfirmPass") != null) {
                if (request.getParameter("txtConfirmPass") != "") {
                    confirmPass = request.getParameter("txtConfirmPass");
                }
            }
            if (!firstName.equals("") && !lastName.equals("") && !email.equals("") && !password.equals("") && !confirmPass.equals("")) {
                user = new User(firstName, lastName, email, password);
                user.saveUserInfo();
                response.sendRedirect("index.jsp");
            }
            else{
                out.println("<script>alert('You must enter all required information');</script>");       
            }
        }

        if (request.getParameter("btnCancel") != null) {
            response.sendRedirect("index.jsp");
        }
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <form id=\"frmRegistration\" action=\"Registration.jsp\" method=\"post\">\n");
      out.write("            <label class=\"label\" for=\"txtFirstName\" >First Name: </label>&nbsp;<input type=\"text\" id=txtFirstName\" name=\"txtFirstName\" value=\"\"></input>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <label class=\"label\" for=\"txtLastName\" >Last Name: </label>&nbsp;<input type=\"text\" id=txtLastName\" name=\"txtLastName\" value=\"\"></input>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <label class=\"label\" for=\"txtEmail\" >Email: </label>&nbsp;<input type=\"text\" id=txtEmail\" name=txtEmail\" value=\"\"></input>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <label class=\"label\" for=\"txtPass\" >Password: </label>&nbsp;<input type=\"password\" id=\"txtPass\" name=\"txtPass\" value=\"\"></input>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <label class=\"label\" for=\"txtConfirmPass\" >Confirm Password: </label>&nbsp;<input type=\"password\" id=txtConfirmPass\" name=txtConfirmPass\" value=\"\"></input>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <input class=\"button\" type =\"submit\" id=\"btnRegister\" name=\"btnRegister\" value=\"Register\"></input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            <input class=\"button\" type =\"submit\" id=\"btnCancel\" name=\"btnCancel\" value=\"Cancel\"></input>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("        </form>\n");
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
