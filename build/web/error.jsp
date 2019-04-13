<%-- 
    Document   : error
    Created on : Dec 12, 2018, 10:19:36 PM
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
        <h1>ERROR PAGE</h1><br/>
        <font color = "red">
            ${requestScope.ERROR}
        </font><br/>
        <a href="login.jsp">Click here to try again</a><br/>
        <a href="createNewAccount.jsp">Click here to Register</a>
    </body>
</html>
