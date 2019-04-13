<%-- 
    Document   : customer
    Created on : Dec 12, 2018, 10:26:15 PM
    Author     : Phung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
    </head>
    <body>
        <h1><font color = "green">Hello ${sessionScope.USER}</font></h1>
         <form action="OrderServlet" method="POST">
           <input type="submit" name="btnAction" value="LOG OUT" style=" background-color: cadetblue; font-family: cursive; width: 150px"/>
        </form><br>
    
         <form action="OrderServlet" method="POST">
             <input type="submit" name="btnAction" value="View Profile" style=" background-color: cadetblue; font-family: fantasy; font-size: large"/><br/>
            
            <center>
                
                Min: <input type="text" name="txtMin" value="${param.txtMin}"/>
                Max: <input type="text" name="txtMax" value="${param.txtMax}"/>
            <input type="submit" name="btnAction" value="Search By Price" style=" background-color: cadetblue; font-family: cursive; width: 150px"/>
            
             <input type="submit" name="btnAction" value="View Cart" style=" background-color: cadetblue; font-family: cursive; width: 100px"/><br/>
             
             
             
             
             
             
            <font color = "red">
            <c:if test="${requestScope.SEARCHPRICEERR !=null}">
                <c:if test="${requestScope.SEARCHPRICEERR.minError !=null}">
                    ${requestScope.SEARCHPRICEERR.minError}
                </c:if>
                
            </c:if>
            </font>
            <font color = "red">
            <c:if test="${requestScope.SEARCHPRICEERR !=null}">
                <c:if test="${requestScope.SEARCHPRICEERR.maxError !=null}">
                    ${requestScope.SEARCHPRICEERR.maxError}
                </c:if>
                
            </c:if>
            </font>
            <br/><br/>
        </form>
            <c:if test="${requestScope.SEARCHBYPRICE !=null}">
                <c:if test="${ not empty requestScope.SEARCHBYPRICE }" var="check">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Product ID</th>
                            <th>Name</th>
                            <th>Brand</th>
                            <th>Price</th>
                            <th>Buy</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.SEARCHBYPRICE}" var="dto" varStatus="counter">
                            
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.productID}</td>
                                <td>${dto.name}</td>
                                <td>${dto.brand}</td>
                                <td>${dto.price}</td>
                               
                                
                                
                                <td>
                                    <c:if test="${dto.quantity ==0}" var="checkQuantity" >
                                        <font color="red">
                                           Out of 
                                        </font>
                                    </c:if>   
                                    <c:if test="${checkQuantity == false}">
                                        <form action="OrderServlet" method="POST">
                                            <input type="hidden" name="txtProductID" value="${dto.productID}"/>
                                            <input type="hidden" name="txtName" value="${dto.name}"/>
                                            <input type="hidden" name="txtBrand" value="${dto.brand}"/>
                                            <input type="hidden" name="txtPrice" value="${dto.price}"/>
                                            <input type="hidden" name="txtStatus" value="${dto.status}"/>
                                            <input type="hidden" name="txtQuantity" value="${dto.quantity}"/>
                                            <input type="hidden" name="txtType" value="${dto.type}"/>
                                            <input type="hidden" name="txtMin" value="${param.txtMin}"/>
                                            <input type="hidden" name="txtMax" value="${param.txtMax}"/>
                                            <input type="submit" name="btnAction" value="Buy" style=" background-color: cadetblue; font-family: cursive; width: 100px"/>
                                        </form>
                                    </c:if>
                                    
                                </td>
                            </tr>
                       </c:forEach>
                    </tbody>
                </table>

                
                
                
                </c:if>
                <c:if test="${check ==false}">
                   No record match 
                </c:if>
            </c:if>
            
        
        </center>
        
    </body>
</html>
