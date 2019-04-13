
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
import sample.product.ProductDAO;
import sample.product.ProductDTO;

/**
 *
 * @author Phung Nguyen
 */
public class CheckOutServlet extends HttpServlet {

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
        try  {
            HttpSession session = request.getSession();
            
            String giftID = request.getParameter("gift");
           
            //random OrderID
            String orderID = "C";
            ArrayList<Integer> list = new ArrayList();
            int n = RandomID.randomOrderID();
            
            for (Integer x : list) {
                while(x == n){
                    n = RandomID.randomOrderID();
                }
            }
            list.add(n);
            
            
            orderID = orderID + String.valueOf(n);
            request.setAttribute("ORDERID", orderID);
            
            // thong tin customer
             String id = (String)session.getAttribute("USER");
            AccountDAO accountDAO = new AccountDAO();
            AccountDTO accountDTO = accountDAO.findById(id);
            request.setAttribute("ACCOUNTDTO" , accountDTO);
             
            // find gift
            if(giftID!=null){
                int quantity = Integer.parseInt(request.getParameter("txtQuantityGift"));
                ProductDAO productDAO = new ProductDAO();
                productDAO.downQuantity(giftID, quantity);
                ProductDTO productDTO = new ProductDTO();
                productDTO= productDAO.findById(giftID);
               request.setAttribute("GIFTDTO", productDTO);
            }
            
           
           
        }
        catch(Exception e){
            log("ERROR at CheckOutServlet " + e.getMessage());
           
        }
        finally{
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
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
