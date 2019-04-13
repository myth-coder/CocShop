
package sample.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.obj.CartObj;
import sample.product.ProductDAO;
import sample.product.ProductDTO;

/**
 *
 * @author Phung Nguyen
 */
public class AddItemServlet extends HttpServlet {
    
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
        try{
            String productID = request.getParameter("txtProductID");
            String name = request.getParameter("txtName");
            String brand = request.getParameter("txtBrand");
            float price = Float.parseFloat(request.getParameter("txtPrice"));
            String min = request.getParameter("txtMin");
            String max = request.getParameter("txtMax");
            String status = request.getParameter("txtStatus");
            String type = request.getParameter("txtType");
            
            
            
            ProductDTO dto = new ProductDTO(productID, name, brand, price, 1, status, type);
            HttpSession session = request.getSession();
            String customerName =(String) session.getAttribute("USER");
            CartObj cart = (CartObj) session.getAttribute("SHOPPINGCART");
            
            if(cart==null){
                cart = new CartObj(customerName);
            }
            cart.addToCart(dto);
            session.setAttribute("SHOPPINGCART", cart);
            
            
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            ProductDAO dao = new ProductDAO();
            dao.downQuantity(productID, quantity);
            // load Gift
            List<ProductDTO> listGift =  dao.loadListGift();
            
            if(listGift!=null){
                session.setAttribute("LISTGIFT",listGift );
               
            }
                    
                
            
        }
        catch(Exception e){
            log("ERROR at AddItemServlet " + e.getMessage());
        }
        finally{
            request.getRequestDispatcher("SearchByPriceServlet").forward(request, response);
                   
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
