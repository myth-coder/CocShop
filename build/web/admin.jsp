<%-- 
    Document   : admin
    Created on : Dec 12, 2018, 10:25:35 PM
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
       <font color="green">Hello ${sessionScope.USER}</font>
       <form action="OrderServlet" method="POST">
           <input type="submit" name="btnAction" value="LOG OUT" style=" background-color: cadetblue; font-family: cursive; width: 150px"/>
       </form>
        
       <br/>
         
        <form action="OrderServlet" method="POST">
            
            <input type="submit" name="btnAction" value="My Profile" style=" background-color: cadetblue; font-family: cursive; width: 150px"/><br/>
            <center>
            <h1><font color="GREEN">COC SHOP MANAGEMENT</font></h1> 
            <input type="submit" name="btnAction" value="Search By Name" style=" background-color: cadetblue; font-family: initial; font-size: xx-large"/>
            <input type="submit" name="btnAction" value="Create new Product" style=" background-color: cadetblue; font-family: initial; font-size: xx-large"/>
          </center>
        </form>
        
    </body>
</html>
