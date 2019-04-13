<%-- 
    Document   : confirm
    Created on : Dec 16, 2018, 2:00:21 AM
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
        </form>
        <h1>Order Successfully</h1>
        <a href="customer.jsp">Home Page</a>
        <% 
            if(session.getAttribute("SHOPPINGCART")!=null){
                session.removeAttribute("SHOPPINGCART");
            }
          %>  
          
    </body>
</html>
