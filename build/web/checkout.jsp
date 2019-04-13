<%-- 
    Document   : checkout
    Created on : Dec 15, 2018, 4:36:02 AM
    Author     : Phung Nguyen
--%>

<%@page import="sample.orders.OrderErr"%>
<%@page import="sample.account.AccountDTO"%>
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
        
    <center>
        <form action="OrderServlet" method="POST">
           <input type="submit" name="btnAction" value="LOG OUT" style=" background-color: cadetblue; font-family: cursive; width: 150px"/>
        </form><br>
        <h1>Finish Your Order</h1>
         <form action="OrderServlet" method="POST">
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
                                          
                                      </tr>
                                  </thead>
                                  <tbody>
                                      <% for (ProductDTO productDTO : cart.getCart().values()) {
                                          %>
                                            <tr>
                                                <td><%= productDTO.getProductID() %></td>
                                                <td><%=productDTO.getName() %></td>
                                                <td><%=productDTO.getBrand() %></td>
                                                
                                                <td><%= productDTO.getQuantity() %></td>
                                                <td><%= productDTO.getPrice() %></td>
                                                
                                               
                                            </tr>
                                      
                                      <%    
                                          }
                                      %>
                                  <td colspan="4">Total:<%= cart.getTotal() %> </td>
                                   <% }
                                        }
                                   %> 
                                   <td> Gift:
                                       <%
                                           
                                           ProductDTO productDTO = (ProductDTO) request.getAttribute("GIFTDTO");
                                         if(productDTO!= null){
                                             %>
                                            <%=  productDTO.getName()%>
                                         <% }
                                       
                                       %>
                                   </td>
                                   
                                   
                                   
                              </tbody>
                        </table>
                                   
                                    
                                   
                                        <% AccountDTO accountDTO = (AccountDTO) request.getAttribute("ACCOUNTDTO") ;
                                        if(accountDTO!=null){
                                            

                                                %>
                                                <h3>Customer Information</h3>
                                                Order ID:<input type="text" name="txtOrderID" value="<%=request.getAttribute("ORDERID") %>" readonly="true"/><br/>
                                                     Account ID:<input type="text" name="txtAccountID" value="<%= accountDTO.getAccountID() %>" readonly="true"/><br/>
                                                     Full Name:<input type="text" name="txtFullName" value="<%= accountDTO.getFullName() %>" readonly="true"/><br/>
                                                     Phone Number<input type="text" name="txtPhoneNumber" value="<%= accountDTO.getPhoneNumber() %>" readonly="true"/><br/>
                                                     Address:<input type="text" name="txtAddress" value="<%= accountDTO.getAddress() %>" readonly="true"/><br/>
                                                     <% String add = "";
                                                         if(request.getParameter("txtReceiverAdd")!=null){
                                                             add = request.getParameter("txtReceiverAdd");
                                                        }
                                                        String phone = "";
                                                         if(request.getParameter("txtReceivePhone")!=null){
                                                             phone = request.getParameter("txtReceivePhone");
                                                        }   
                                                         %>
                                                     Receiver Address*:<input type="text" name="txtReceiverAdd" value="<%= add %>"/><br/>
                                                     <font color = "red">
                                                     <% 
                                                         OrderErr errors = (OrderErr)request.getAttribute("INVALID");
                                                         if(errors!=null){
                                                            if(errors.getAddressErr()!=null){
                                                                %>
                                                                <%= errors.getAddressErr() %><%
                                                            }
                                                        }


                                                     %>
                                                     </font><br/>
                                                     Receiver Phone *:<input type="text" name="txtReceivePhone" value="<%= phone %>"/><br/>
                                                     <font color = "red">
                                                     <% 
                                                      
                                                         if(errors!=null){
                                                            if(errors.getPhoneNumberErr()!=null){
                                                                %>
                                                                <%= errors.getPhoneNumberErr() %><%
                                                            }
                                                        }


                                                     %>
                                                     </font><br/>
                                                     <input type="submit" name="btnAction" value="Confirm" style=" background-color: cadetblue; font-family: cursive; width: 100px" />
                                                     <a href="viewCart.jsp"style="color: mediumseagreen; font-family: fantasy; font-size: large">BACK</a>
                                                     <input type="hidden" name="txtOrderID" value="<%=request.getAttribute("ORDERID") %>"/>

                                         <%                       
                                           }

                                         %>
                                   
        
        </form>
        
    </center>
    </body>
</html>
