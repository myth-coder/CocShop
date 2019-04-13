<%-- 
    Document   : errors
    Created on : Dec 13, 2018, 1:21:31 AM
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
        error page
        ${requestScope.ERRORS}
    </body>
</html>
