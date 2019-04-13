<%-- 
    Document   : CreatProduct
    Created on : Dec 13, 2018, 10:23:53 PM
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
        
        <font color="green">Hello ${sessionScope.USER}</font>
        
    <form action="OrderServlet" method="POST">
         <input type="submit" name="btnAction" value="LOG OUT" style=" background-color: cadetblue; font-family: cursive; width: 150px"/><br/>
          <input type="submit" name="btnAction" value="My Profile" style=" background-color: cadetblue; font-family: cursive; width: 150px"/><br/>
    </form>
          <center>
        <h1><font color = "Green">CREATE NEW PRODUCT</font></h1>
        <form action="OrderServlet" method="POST">
            Product ID: <input type="text" name="txtProductID" value="${param.txtProductID}"/>(1-10 chars)<br/>
            <font color = "red">
                <c:if test="${requestScope.INSERTERR!= null}">
                    <c:if test="${not empty requestScope.INSERTERR.productIdErr}">
                        ${requestScope.INSERTERR.productIdErr}
                    </c:if>
                    <c:if test="${not empty requestScope.INSERTERR.productIdDuplicate}">
                         ${requestScope.INSERTERR.productIdDuplicate}
                    </c:if>
                </c:if>
            </font><br/>
            
            
            
            Name: <input type="text" name="txtName" value="${param.txtName}"/>(2-50 chars)<br/>
            <font color = "red">
                <c:if test="${requestScope.INSERTERR!= null}">
                    <c:if test="${not empty requestScope.INSERTERR.nameErr}">
                        ${requestScope.INSERTERR.nameErr}
                    </c:if>
                </c:if>
            </font><br/>
            Brand:<input type="text" name="txtBrand" value="${param.txtBrand}"/>(1-20 chars)<br/>
             <font color = "red">
                <c:if test="${requestScope.INSERTERR!= null}">
                    <c:if test="${not empty requestScope.INSERTERR.brandErr}">
                        ${requestScope.INSERTERR.brandErr}
                    </c:if>
                </c:if>
            </font><br/>
            Price:<input type="text" name="txtPrice" value="${param.txtPrice}"/>(digit )<br/>
             <font color = "red">
                <c:if test="${requestScope.INSERTERR!= null}">
                    <c:if test="${not empty requestScope.INSERTERR.priceErr}">
                        ${requestScope.INSERTERR.priceErr}
                    </c:if>
                </c:if>
            </font><br/>
            Quantity: <input type="text" name="txtQuantity" value="${param.txtQuantity}"/>(digit)<br/>
             <font color = "red">
                <c:if test="${requestScope.INSERTERR!= null}">
                    <c:if test="${not empty requestScope.INSERTERR.quantityErr}">
                        ${requestScope.INSERTERR.quantityErr}
                    </c:if>
                </c:if>
            </font><br/>
            Status: <input type="text" name="txtStatus" value="${param.txtStatus}"/>(~50 chars)<br/>
             <font color = "red">
                <c:if test="${requestScope.INSERTERR!= null}">
                    <c:if test="${not empty requestScope.INSERTERR.statusErr}">
                        ${requestScope.INSERTERR.statusErr}
                    </c:if>
                </c:if>
            </font><br/>
            Type: <select name="txtType">
                        <option value="F">Food</option>
                        <option value="D">Drink</option>
                        <option value="G">Gift</option>
                  </select><br/><br/>
                  <input type="submit" name="btnAction" value="Create"/>
            
        </form>
        <br/><a href="admin.jsp">Home page</a>
    </center>
    </body>
</html>
