<%-- 
    Document   : SearchProductByName
    Created on : Dec 13, 2018, 1:25:25 AM
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
        <br>
            <input type="submit" name="btnAction" value="My Profile" style=" background-color: cadetblue; font-family: cursive; width: 150px"/><br/>
         </form>
        <form action="SearchProductByNameServlet" method="POST">
             
            <center>
             Name: <input type="text" name="txtSearch" value="${param.txtSearch}"/>
            
            <input type="submit" name="btnAction" value="Search" style=" background-color: cadetblue; font-family: cursive; font-size: large"/>
             <a href="admin.jsp"><font color  = "green">Home page</font></a><br/>
            <font color = "red">
                ${requestScope.SEARCHERR.searchError}
            </font>
           
        </form>
              
              <br/><br/>
        <c:if test="${requestScope.SEARCHBYNAME !=null}" var="check">
            <c:if test="${not empty requestScope.SEARCHBYNAME}" var="check">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Product ID</th>
                            <th>Name</th>
                            <th>Brand</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Status</th>
                            <th>Type</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                   
                        <c:forEach items="${requestScope.SEARCHBYNAME}" var="dto" varStatus="counter">
                             
                       
                        <tr>
                            <td> ${counter.count}</td>
                            <td>${dto.productID}</td>     
                            <td>${dto.name} </td>
                            <td> ${dto.brand}</td>
                            <td>${dto.price}</td>
                            <td> ${dto.quantity}</td>
                            <td> ${dto.status} </td>
                            <td>${dto.type}</td>
                            <td>
                                <c:url var="delete" value="OrderServlet" >
                                    <c:param name="btnAction" value="Delete"/>
                                    <c:param name="id" value="${dto.productID}"/>
                                    <c:param name="txtSearch" value="${param.txtSearch}"/>
                                    
                                    
                                </c:url>
                                <a href="${delete}">Delete</a>
                            </td> 
                            <td>
                                <form action="OrderServlet" method="POST">
                       
                                    <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                    <input type="hidden" name="txtProductID" value="${dto.productID}"/>
                                    <input type="submit" name="btnAction" value="Edit"  style=" background-color: cadetblue; font-family: cursive; width: 150px"/>    
                                </form>
                            </td>
                        </tr>

                        
                         </c:forEach>
                       
                    </tbody>
                </table>

                
                
                
                
            </c:if>
            <c:if test="${check == false}">
                No record match
            </c:if>
        </c:if>
        
               
        
        
    </center>
    </body>
</html>
