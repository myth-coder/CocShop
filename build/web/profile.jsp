<%-- 
    Document   : profile
    Created on : Dec 13, 2018, 11:42:53 PM
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
        <h1>Profile</h1>
        <form action="OrderServlet" method="POST">
          
            Account ID: <input type="text" name="txtAcountID" value="${requestScope.INFO.accountID}" readonly="true"/><br/>
            Password : <input type="password" name="txtPassword" value="" maxlength="10" minlength="10"/><br/>
            <font color = "red">
                <c:if test="${requestScope.UPDATEACCOUNTERR !=null}">
                    <c:if test="${requestScope.UPDATEACCOUNTERR.passwordErr !=null}">
                        ${requestScope.UPDATEACCOUNTERR.passwordErr}
                    </c:if>
                </c:if>
            
            </font><br/>
            Full Name : <input type="text" name="txtFullName" value="${requestScope.INFO.fullName}"/><br/>
            <font color = "red">
                <c:if test="${requestScope.UPDATEACCOUNTERR !=null}">
                    <c:if test="${requestScope.UPDATEACCOUNTERR.fullNameErr !=null}">
                        ${requestScope.UPDATEACCOUNTERR.fullNameErr}
                    </c:if>
                </c:if>
            
            </font><br/>
            Address: <input type="text" name="txtAddress" value="${requestScope.INFO.address}"/><br/>
            <font color = "red">
                <c:if test="${requestScope.UPDATEACCOUNTERR !=null}">
                    <c:if test="${requestScope.UPDATEACCOUNTERR.addressErr !=null}">
                        ${requestScope.UPDATEACCOUNTERR.addressErr}
                    </c:if>
                </c:if>
            
            </font><br/>
            Phone Number: <input type="text" name="txtPhone" value="${requestScope.INFO.phoneNumber}"/><br/>
            <font color = "red">
                <c:if test="${requestScope.UPDATEACCOUNTERR !=null}">
                    <c:if test="${requestScope.UPDATEACCOUNTERR.phoneNumberErr !=null}">
                        ${requestScope.UPDATEACCOUNTERR.phoneNumberErr}
                    </c:if>
                </c:if>
            
            </font><br/>
            Role ID: <input type="text" name="txtRoleID" value="${requestScope.INFO.roleID}" readonly="true"/><br/>
            Status: <input type="text" name="txtStatus" value="${requestScope.INFO.status}" readonly="true"/><br/>
            <input type="submit" name="btnAction" value="Update Account" style=" background-color: cadetblue; font-family: cursive; width: 150px"/>
            
            <a href="OrderServlet?btnAction=ask&txtAcountID=${requestScope.INFO.accountID}">Delete Account</a>
            <br/>
             <a href="admin.jsp"><font color  = "green">Home page</font></a>
        </form>
    </center>
        
    </body>
</html>
