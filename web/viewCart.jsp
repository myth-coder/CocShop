<%-- 
    Document   : viewCart
    Created on : Dec 14, 2018, 11:32:48 PM
    Author     : Phung Nguyen
--%>

<%@page import="java.util.AbstractList"%>
<%@page import="com.sun.xml.internal.bind.v2.runtime.reflect.Lister.Pack"%>
<%@page import="java.util.List"%>
<%@page import="sample.product.ProductDTO"%>
<%@page import="sample.obj.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
           <br/>
            <input type="submit" name="btnAction" value="View Profile" style=" background-color: mediumseagreen; font-family: fantasy; font-size: large"/><br/>
        </form><br>
        <center>
            
            <form action="OrderServlet" method="POST" >
                <%
                  
                      CartObj cart = (CartObj) session.getAttribute("SHOPPINGCART");
                      if(cart!=null){
                          if(cart.getCart().values().size() > 0){
                              %>
                              <h1 style="color: royalblue">Your Cart </h1><br/><br/>
                              <table border="1">
                                  <thead>
                                      <tr>
                                          <th>Product ID</th>
                                          <th>Name</th>
                                          <th>Brand</th>
                                          <th>Quantity</th>
                                          <th>Price</th>
                                          <th>Remove</th>
                                      </tr>
                                  </thead>
                                  <tbody>
                                      <% for (ProductDTO dto : cart.getCart().values()) {
                                          %>
                                            <tr>
                                                <td><%= dto.getProductID() %></td>
                                                <td><%=dto.getName() %></td>
                                                <td><%=dto.getBrand() %></td>
                                                
                                                <td><%= dto.getQuantity() %></td>
                                                <td><%= dto.getPrice() %></td>
                                                <td>
                                                    <input type="checkbox" name="rmv" value="<%= dto.getProductID() %>"/>
                                                    <input type="hidden" name="txtQuantity" value="<%=dto.getQuantity()%>"/>
                                                    
                                                </td>
                                               
                                            </tr>
                                      
                                      <%    
                                          }
                                      %>
                                  <td></td>   
                                  <td></td>    
                                  <td colspan="2">
                                              <a href="OrderServlet?btnAction=Search By Price&txtMin=<%=request.getParameter("txtMin")%>&txtMax=<%=request.getParameter("txtMax")%>">Continues Order</a>
                                  </td>
                                          <td>Total:<%= cart.getTotal() %> </td>
                                          <td>
                                              <input type="hidden" name="txtMin" value="<%=request.getParameter("txtMin")%>"/>
                                              <input type="hidden" name="txtMax" value="<%=request.getParameter("txtMax")%>"/>
                                              <input type="submit" name="btnAction" value="Remove" style="font-family: fantasy; font-size: xx-large"/>
                                          </td>
                                         
                                      
                                       
                                  </tbody>
                                  
                              </table><br/><br/>
                               <%
                                   List<ProductDTO> listGift = (List<ProductDTO>) session.getAttribute("LISTGIFT");
                                   if(listGift!= null){
                                    if( cart.getTotal() > 200000 && listGift.size()>0 ){
                                   %>
                                   <p style="color: chocolate">Total price of you great than 200.000 dong<br/>
                                       So we will give you one of List Gift. Select to choice:</p>
                                   
                              <%
                                        for (ProductDTO dto : listGift) {
                                               %> <input type="radio"  name = "gift" value="<%= dto.getProductID() %>"/> <%= dto.getName() %> <br/>
                                                 <input type="hidden" name="txtQuantityGift" value="<%= dto.getQuantity() %>"/>
                                          <%  }
                                  
                               }
                            }
                               %>               
                              <input type="submit" name="btnAction" value="Check Out" style=" background-color: mediumseagreen; font-family: fantasy; font-size: xx-large" /> 
                              <%
                                  return;
                          }
                    
                      }
                    
                %>   <h4><font style="color: darkgreen">Your cart is empty</font></h4>
                <br/><a href="OrderServlet?btnAction=Search By Price&txtMin=<%=request.getParameter("txtMin")%>&txtMax=<%=request.getParameter("txtMax")%>">Continues Order</a>
    
                
            </form>
               
        </center>
    </body>
</html>
