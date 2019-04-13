
package sample.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phungnt.utils.checkValidate;
import sample.product.ProductDAO;
import sample.product.ProductDTO;
import sample.product.SearchError;

/**
 *
 * @author Phung Nguyen
 */
public class SearchByPriceServlet extends HttpServlet {

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
           String min = request.getParameter("txtMin");
           String max = request.getParameter("txtMax");
            SearchError errors = new SearchError();
            boolean error = false;
            if(min.trim().length() == 0 || !checkValidate.getPrice(min)){
                error = true;
                errors.setMinError("Min value invalid");
            }
            if(max.trim().length() == 0 || !checkValidate.getPrice(max)){
                error = true;
                errors.setMaxError("Max value invalid");
            }
            if(!error){
                ProductDAO dao = new ProductDAO();
                List<ProductDTO> result = dao.searchByPrice(Float.parseFloat(min), Float.parseFloat(max));
                if(result!=null){
                    request.setAttribute("SEARCHBYPRICE", result);
                }
                
            }
            else{
                request.setAttribute("SEARCHPRICEERR", errors);
                
            }
           
           
        }
        catch(Exception e){
            log("ERROR at SearchByPriceServlet " + e.getMessage());
        }
        finally{
            request.getRequestDispatcher("customer.jsp").forward(request, response);
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
