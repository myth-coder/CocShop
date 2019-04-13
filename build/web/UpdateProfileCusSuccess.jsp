<%-- 
    Document   : UpdateProfileCusSuccess
    Created on : Dec 16, 2018, 3:59:08 AM
    Author     : Phung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><font color="green"> ${sessionScope.USER}</font></h1> <br/>
        <form action="OrderServlet" method="POST">
           <input type="submit" name="btnAction" value="LOG OUT" style=" background-color: cadetblue; font-family: cursive; width: 150px"/>
        </form><br>
        <h3 style="color: darkseagreen">Update Profile Successfully</h3><br/>
        <a href="customer.jsp"><font color  = "green">Home page</font></a>
    </body>
</html>
