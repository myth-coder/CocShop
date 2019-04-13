<%-- 
    Document   : createNewAccount
    Created on : Dec 16, 2018, 4:31:29 AM
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
           <input type="submit" name="btnAction" value="LOG OUT" style=" background-color: cadetblue; font-family: cursive; width: 150px"/>
        </form><br>
        <center>
        <h2>REGISTER</h2>
        <form action="OrderServlet" method="POST">
            Account ID: <input type="text" name="txtAccountID" value="${param.txtAccountID}"/><br/>
            <font color = "red">
            <c:if test="${not empty requestScope.INVALIDRES }">
                <c:if test="${not empty requestScope.INVALIDRES.idErr}">
                    ${requestScope.INVALIDRES.idErr}
                </c:if>
            </c:if>
            
            <c:if test="${not empty requestScope.INVALIDRES}">
                <c:if test="${not empty requestScope.INVALIDRES.idDup}">
                    ${requestScope.INVALIDRES.idDup}
                </c:if>
            </c:if>
            </font><br/>
            Password: <input type="password" name="txtPassword" value=""/><br/>
            <font color = "red">
            <c:if test="${not empty requestScope.INVALIDRES }">
                <c:if test="${not empty requestScope.INVALIDRES.passwordErr}">
                    ${requestScope.INVALIDRES.passwordErr}
                </c:if>
            </c:if>
            </font><br/>
            Full Name: <input type="text" name="txtFullName" value="${param.txtFullName}"/><br/>
            <font color = "red">
            <c:if test="${not empty requestScope.INVALIDRES }">
                <c:if test="${not empty requestScope.INVALIDRES.fullName}">
                    ${requestScope.INVALIDRES.fullName}
                </c:if>
            </c:if>
            </font><br/>
            Address:<input type="text" name="txtAddress" value="${param.txtAddress}"/><br/>
            <font color = "red">
            <c:if test="${not empty requestScope.INVALIDRES }">
                <c:if test="${not empty requestScope.INVALIDRES.address}">
                    ${ requestScope.INVALIDRES.address}
                </c:if>
            </c:if>
            </font><br/>
            Phone Number: <input type="text" name="txtPhoneNumber" value="${param.txtPhoneNumber}"/><br/>
            <font color = "red">
            <c:if test="${not empty requestScope.INVALIDRES }">
                <c:if test="${not empty requestScope.INVALIDRES.phoneNumber}">
                    ${requestScope.INVALIDRES.phoneNumber}
                </c:if>
            </c:if>
            </font><br/>
            <input type="submit" name="btnAction" value="Register"/>
            <input type="reset" name="Reset" value="Reset"/>
            
        </form>
        </center>
    </body>
</html>
