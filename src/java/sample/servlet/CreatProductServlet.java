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
import sample.product.CreateProductError;
import sample.product.ProductDAO;

/**
 *
 * @author Phung Nguyen
 */
public class CreatProductServlet extends HttpServlet {

    private static final String ERRORS = "errors.jsp";
    private static final String INVALID = "CreatProduct.jsp";
    private static final String SUCCESS = "CreatProductSuccess.jsp";

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
        String url = ERRORS;
        CreateProductError errors = new CreateProductError();
        boolean error = false;
        String id = request.getParameter("txtProductID");
        try {
             String name = request.getParameter("txtName");
           
            String brand = request.getParameter("txtBrand");
            String price = request.getParameter("txtPrice");
            String quantity = request.getParameter("txtQuantity");
            String status = request.getParameter("txtStatus");
            String type = request.getParameter("txtType");

            if (id.trim().length() == 0 || id.trim().length() > 10) {
                error = true;
                errors.setProductIdErr("ID required 1-10 chars");
            }
            if (name.trim().length() == 0 || name.trim().length() < 2 || name.trim().length() > 50) {
                error = true;
                errors.setNameErr("Name requires 2 -50 chars");
            }
             if (brand.trim().length() == 0  || brand.trim().length() > 20) {
                error = true;
                errors.setBrandErr("Brand requires 1-20 chars");
            }
            if (price.trim().length() == 0 || !checkValidate.getPrice(price)) {
                error = true;
                errors.setPriceErr("Price is digit");
            }
            if (quantity.trim().length() == 0 || !checkValidate.getInt(quantity)) {
                error = true;
                errors.setQuantityErr("Quantity is digit");
            }
            if (status.trim().length() > 50) {
                error = true;
                errors.setStatusErr("Max length Status is 50");
            }
            if (!error) {
                ProductDAO dao = new ProductDAO();
                boolean result = dao.insert(id, name, brand, price, quantity, status, type);
                if (result) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERRORS", "Insert Failed!");
                }

            } 
            else {
                request.setAttribute("INSERTERR", errors);
                url = INVALID;
            }
        } 
        catch (Exception e) {
            log("ERROR at CreatProductServlet " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                errors.setProductIdDuplicate( id + " already exist");
                 request.setAttribute("INSERTERR", errors);
                url = INVALID;
            }
        } 
        finally {
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
