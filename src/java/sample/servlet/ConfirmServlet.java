
package sample.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phungnt.utils.RandomID;
import sample.account.AccountDAO;
import sample.account.AccountDTO;
import sample.obj.CartObj;
import sample.orderdetail.OrderDetailDAO;
import sample.orders.OrderDAO;
import sample.orders.OrderErr;
import sample.product.ProductDTO;

/**
 *
 * @author Phung Nguyen
 */
public class ConfirmServlet extends HttpServlet {
     private static final String INVALID = "checkout.jsp";
     private static final String SUCCESS = "confirm.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = INVALID;
        try  {
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("SHOPPINGCART");
            // random cho id cua tbl_OrderDetails
            String orderDetailID = "S";
            int n = RandomID.randomOrderID();
            ArrayList<Integer> list = new ArrayList<>();
            String address = request.getParameter("txtReceiverAdd");
            String phoneNumber = request.getParameter("txtReceivePhone");
            
            String orderId = (String)request.getParameter("txtOrderID");
            request.setAttribute("ORDERID", orderId);
            float totalPrice = cart.getTotal();
            String accountId = request.getParameter("txtAccountID");
            OrderErr errors = new OrderErr();
            boolean error = false;
            AccountDAO dao = new AccountDAO();
            AccountDTO accountDTO = dao.findById(accountId);
            request.setAttribute("ACCOUNTDTO", accountDTO);
            
            if(address.trim().length() ==0){
                error = true;
                errors.setAddressErr("Address can not be blank");
            }
            if(phoneNumber.trim().length()==0 || phoneNumber.trim().length()!=10 || !phoneNumber.matches("^[0-9]*$")){
                error = true;
                errors.setPhoneNumberErr("invalid Phone number ");
            }
            if(!error){
                OrderDAO oderDAO = new OrderDAO();
                oderDAO.insert(orderId, totalPrice, accountId, address, phoneNumber);
                OrderDetailDAO orderDetaiDAO= new OrderDetailDAO();
                
                for (ProductDTO dto : cart.getCart().values()) {
                    for (Integer x : list) {
                            while(x==n){
                                n = RandomID.randomOrderID();
                            }
                    }
                    list.add(n);
                        orderDetailID = orderDetailID + String.valueOf(n);
                     orderDetaiDAO.insert(orderDetailID, dto.getProductID(), dto.getQuantity(), dto.getPrice(), dto.getPrice()*dto.getQuantity(), orderId);
                }
               url = SUCCESS;
            }
            else{
               url = INVALID;
               request.setAttribute("INVALID", errors);
            }
            
            
            
        }
        catch(Exception e){
             log("ERROR at ConfirmServlet " + e.getMessage());
            
        }
        finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
