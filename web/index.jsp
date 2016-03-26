<%-- 
    Document   : index
    Created on : Feb 18, 2016, 7:01:28 PM
    Author     : Troy
--%>

<%@page import="edu.pitt.is1017.spaceinvaders.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AlienInvasion - Login</title>
        <style type="text/css">
            body{
                font-family: candara;
                color:white;
                background-image: url(http://wallpapercave.com/wp/pEeUsp1.jpg);
                background-size: cover;
                background-repeat: no-repeat;

            }
            h1{
                font-family: candara;
                font-size:68px;
                color:yellow;
                text-align: center;
                letter-spacing: 10px;
                text-shadow: 1px 2px #ff0000
            }
            form{
                text-align: center;
                margin: auto;
                background-color: black;
                border: 4px solid red;
                border-radius: 10px 10px 10px 10px;
                width: 700px;
            }
            .button{
                background-color: #FFFFFF;
                border-radius: 6px;
                font-size: 24px;
                width: 140px;
                padding: 15px 15px;
                text-align: center;
                cursor: pointer;
                display: inline-block;
                box-shadow: 0 2px #999;
            }
            .button:active {
                box-shadow: 0 2px #666;
                transform: translateY(2px);
            }
            .label{
                font-size:24px;
                
            }

        </style>
    </head>
    <%
        String email = "";
        String password = "";
        User user;
        if (request.getParameter("btnSubmit") != null) {
            if (request.getParameter("txtEmail") != null) {
                if (request.getParameter("txtEmail") != "") {
                    email = request.getParameter("txtEmail");
                }
            }
            if (request.getParameter("txtPassword") != null) {
                if (request.getParameter("txtPassword") != "") {
                    password = request.getParameter("txtPassword");
                }
            }

            if (!email.equals("") && !password.equals("")) {
                user = new User(email, password);
                response.sendRedirect("game.jsp");

            } else {
                out.println("<script>alert('You must enter both Email and Password');</script>");
            }
        }
        if (request.getParameter("btnRegister") != null) {
            response.sendRedirect("Registration.jsp");
        }
    %>
    <body>
        <h1>ALIEN INVASION</h1>
        <form id="frmLogin" action="index.jsp" method="post" >
            <br/>
            <label class="label" for="txtEmail">Email:</label>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="txtEmail" name="txtEmail" value=""></input>
            &nbsp;&nbsp;
            <label class="label" for="txtPassword">Password:</label>&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" id="txtPassword" name="txtPassword" value=""></input>
            </br>
            </br>
            </br>
            </br>
            <input class = "button" type ="submit" id="btnSubmit" name="btnSubmit" value="Login"> </input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input class = "button" type ="submit" id="btnRegister" name="btnRegister" value="Register"></input>
            </br>
            </br>
        </form>

    </body>
</html>
