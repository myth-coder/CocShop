<%-- 
    Document   : update
    Created on : Dec 13, 2018, 2:08:30 AM
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
        <h1><font color="green">Hello ${sessionScope.USER}</font></h1><br/>
         <form action="OrderServlet" method="POST">
           <input type="submit" name="btnAction" value="LOG OUT" style=" background-color: cadetblue; font-family: cursive; width: 150px"/>
          <input type="submit" name="btnAction" value="My Profile" style=" background-color: cadetblue; font-family: cursive; width: 150px"/><br/>
         </form><br>
   
         <center>
        <form action="OrderServlet" method="POST">
             
            
             
                  <h2>INFO PRODUCT</h2>
                <c:if test="${requestScope.DTO.productID !=null}" var="id">
                 Product ID: <input type="text" value="${requestScope.DTO.productID}" name="txtProductID" readonly="true"/><br/>
                </c:if>
                <c:if test="${id == false}">
                    Product ID: <input type="text" value="${param.txtProductID}" name="txtProductID" readonly="true"/><br/>
                </c:if>
           
            
                <c:if test="${requestScope.DTO.name !=null}" var="name">
                    Product Name: <input type="text" value="${requestScope.DTO.name}" name="txtName"/>(2-50 chars)<br/>
                </c:if>
                <c:if test="${name == false}">
                    Product Name: <input type="text" value="${param.txtName}" name="txtName"/>(2-50 chars)<br/>
                </c:if>
                
            
            <font color = "red">
            <c:if test="${requestScope.INVALID !=null}">
                <c:if test="${requestScope.INVALID.nameError !=null}">
                    ${requestScope.INVALID.nameError}
                </c:if>
            </c:if>
            </font><br/>
            <c:if test="${requestScope.DTO.brand !=null}" var="brand">
                 Brand:<input type="text" value="${requestScope.DTO.brand}" name="txtBrand"/>(1-20 chars)<br/>
            </c:if>
                <c:if test="${brand == false}">
                    Brand:<input type="text" value="${param.txtBrand}" name="txtBrand"/>(1-20 chars)<br/>
                </c:if>
            
           
            <font color = "red">
            <c:if test="${requestScope.INVALID !=null}">
                <c:if test="${requestScope.INVALID.brandError !=null}">
                    ${requestScope.INVALID.brandError}
                </c:if>
            </c:if>
            </font><br/>
            <c:if test="${requestScope.DTO.price !=null}" var="price">
                 Price:<input type="text" value="${requestScope.DTO.price}" name="txtPrice"/>(digits)<br/>
            </c:if>
                <c:if test="${price == false}">
                    Price:<input type="text" value="${param.txtPrice}" name="txtPrice"/>(digits)<br/>
                </c:if>
            <font color = "red">
            <c:if test="${requestScope.INVALID !=null}">
                <c:if test="${requestScope.INVALID.priceError !=null}">
                    ${requestScope.INVALID.priceError}
                </c:if>
            </c:if>
            </font><br/>
            <c:if test="${requestScope.DTO.quantity !=null}" var="quantity">
                  Quantity:<input type="text" value="${requestScope.DTO.quantity}" name="txtQuantity"/>(digits)<br/>
            </c:if>
                <c:if test="${quantity == false}">
                    Quantity:<input type="text" value="${param.txtQuantity}" name="txtQuantity"/>(digits)<br/>
                </c:if>
           
            <font color = "red">
            <c:if test="${requestScope.INVALID !=null}">
                <c:if test="${requestScope.INVALID.quantityError !=null}">
                    ${requestScope.INVALID.quantityError}
                </c:if>
            </c:if>
            </font><br/>
                <c:if test="${requestScope.DTO.status !=null}" var="status">
                      Status: <input type="text" value="${requestScope.DTO.status}" name="txtStatus"/>( ~50 chars )<br/>
                </c:if>
                <c:if test="${status == false}">
                    Status: <input type="text" value="${param.txtStatus}" name="txtStatus"/>( ~50 chars )<br/>
                </c:if>
           
            <font color = "red">
            <c:if test="${requestScope.INVALID !=null}">
                <c:if test="${requestScope.INVALID.statusError !=null}">
                    ${requestScope.INVALID.statusError}
                </c:if>
            </c:if>
            </font><br/>
            
            Type:<select name="txtType">
                    <option value="F">Food</option>
                    <option value="D">Drink</option>
                    <option value="G">Gift</option>
                </select><br/>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" value="Update" name="btnAction" style=" background-color: cadetblue; font-family: cursive; width: 100px"/>
        </form>
    </center>
    </body>
</html>
