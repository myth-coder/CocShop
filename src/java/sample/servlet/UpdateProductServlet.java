/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phungnt.utils.checkValidate;
import sample.product.ProductDAO;
import sample.product.UpdateError;

/**
 *
 * @author Phung Nguyen
 */
public class UpdateProductServlet extends HttpServlet {
    private static final String ERROR = "errors.jsp";
    private static final String INVALID = "update.jsp";
    private static final String SUCCESS = "SearchProductByNameServlet";
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
        String url = ERROR;
        try{
            String id = request.getParameter("txtProductID");
            String name = request.getParameter("txtName");
            String brand = request.getParameter("txtBrand");
            String price = request.getParameter("txtPrice");
            String quantity = request.getParameter("txtQuantity");
             String status = request.getParameter("txtStatus");
            String type = request.getParameter("txtType");
            
             
            UpdateError errors = new UpdateError();
            
            boolean error = false;
            if(name.trim().length() == 0 || name.trim().length() < 2 || name.trim().length() >50){
                error = true;
                errors.setNameError("Product name require 2 -50 char");
            }
            if(brand.trim().length() == 0|| brand.trim().length() < 1 || brand.trim().length() >20){
                error = true;
                errors.setBrandError("Product name require 1 -20 char");
            }
            if(price.trim().length() == 0 || !checkValidate.getPrice(price)){
                error = true;
                errors.setPriceError("Price is digit require");
            }
            if(quantity.trim().length() == 0|| !checkValidate.getInt(quantity)){
                error =true;
                errors.setQuantityError("Quantity is digit require");
            }
            if(status.length() > 50){
                error = true;
                errors.setStatusError("Status max length is 50 chars");
            }
//            ProductDTO dto = new ProductDTO(price, name, brand, price, quantity, status, type);
            if(!error){
                ProductDAO dao = new ProductDAO();
                boolean result = dao.updateById(id, name, brand, Float.parseFloat(price),Integer.parseInt(quantity), status, type);
                if(result){
                    url = SUCCESS;
                }
                else{
                    request.setAttribute("ERRORS", "update false");
                }
            }
            else{
                url  = INVALID;
                request.setAttribute("INVALID", errors);
                
            }
             
            
            
            
            
        }
        catch(Exception e){
            log("ERROR at UpdateProductServlet " + e.getMessage());
           
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
