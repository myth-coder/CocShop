<%-- 
    Document   : login
    Created on : Dec 12, 2018, 9:49:14 PM
    Author     : Phung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="OrderServlet" method="POST">
            Username: <input type="text" name="txtUsername" value="${param.txtUsername}"/><br/>
            <font color = "red">
            <c:if test="${ not empty requestScope.INVALID}">
                <c:if test="${not empty requestScope.INVALID.nameErr}">
                    ${requestScope.INVALID.nameErr}
                </c:if>
            </c:if>
            
            </font> <br/>
            Password: <input type="password" name="txtPassword" value=""/><br/>
            <font color = "red">
            <c:if test="${not empty requestScope.INVALID}">
                <c:if test="${not empty requestScope.INVALID.passwordErr}">
                    ${requestScope.INVALID.passwordErr}
                </c:if>
            </c:if>
            
            </font> <br/>
            
            <input type="submit" name="btnAction" value="Login" style=" background-color: cadetblue; font-family: cursive; width: 100px" />
        </form>
    </body>
</html>
