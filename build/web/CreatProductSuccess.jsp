<%-- 
    Document   : CreatProductSuccess
    Created on : Dec 13, 2018, 11:21:03 PM
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
        <form action="OrderServlet" method="POST">
           <input type="submit" name="btnAction" value="LOG OUT" style=" background-color: cadetblue; font-family: cursive; width: 150px"/>
        </form><br>
        <h1><font color = "red">Create product successfully</font></h1><br/>
        <a href="admin.jsp">Home page</a>
    </body>
</html>
