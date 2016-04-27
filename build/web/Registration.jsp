<%-- 
    Document   : Registration
    Created on : Mar 3, 2016, 6:40:34 PM
    Author     : Troy Dinkel
--%>

<%@page import="edu.pitt.is1017.spaceinvaders.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AlienInvasion - Registration</title>
        <style>
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
                margin:auto;
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
    %>
    <body>
        <h1>REGISTRATION</h1>
        <form id="frmRegistration" action="Registration.jsp" method="post">
            <label class="label" for="txtFirstName" >First Name: </label>&nbsp;<input type="text" id=txtFirstName" name="txtFirstName" value=""></input>
            <br/>
            <br/>
            <label class="label" for="txtLastName" >Last Name: </label>&nbsp;<input type="text" id=txtLastName" name="txtLastName" value=""></input>
            <br/>
            <br/>
            <label class="label" for="txtEmail" >Email: </label>&nbsp;<input type="text" id=txtEmail" name=txtEmail" value=""></input>
            <br/>
            <br/>
            <label class="label" for="txtPass" >Password: </label>&nbsp;<input type="password" id="txtPass" name="txtPass" value=""></input>
            <br/>
            <br/>
            <label class="label" for="txtConfirmPass" >Confirm Password: </label>&nbsp;<input type="password" id=txtConfirmPass" name=txtConfirmPass" value=""></input>
            <br/>
            <br/>
            <br/>
            <input class="button" type ="submit" id="btnRegister" name="btnRegister" value="Register"></input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input class="button" type ="submit" id="btnCancel" name="btnCancel" value="Cancel"></input>
            <br/>
            <br/>
        </form>
    </body>
</html>
