<%-- 
    Document   : cusChoice
    Created on : Dec 16, 2018, 3:52:58 AM
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
       <h1>Do you want to delete your account?</h1>
        <br/>
        <a href="OrderServlet?btnAction=Delete Account&txtAcountID=${param.txtAcountID}">Continues</a>
        <a href="customer.jsp">Back</a>
    </body>
</html>
