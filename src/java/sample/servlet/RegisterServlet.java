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
import sample.account.AccountDAO;
import sample.account.AccountErr;

/**
 *
 * @author Phung Nguyen
 */
public class RegisterServlet extends HttpServlet {
     private static final String INVALID = "createNewAccount.jsp";
     private static final String SUCCESS = "login.jsp";
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
        String url  =INVALID;
        AccountErr errors = new AccountErr();
        boolean error = false;
         String id = request.getParameter("txtAccountID");
        try  {
           
            String password = request.getParameter("txtPassword");
            String fullName = request.getParameter("txtFullName");
            String address = request.getParameter("txtAddress");
            String phoneNumber = request.getParameter("txtPhoneNumber");
            if(id.trim().length() == 0){
                error = true;
                errors.setIdErr("Account ID can not be blank");
            }
            if(fullName.trim().length() == 0){
                error = true;
                errors.setFullName("FullName can not be blank");
            }
            if(address.trim().length() == 0){
                error = true;
                errors.setAddress("Address can not be blank");
            }
            if(password.trim().length() ==0){
                error = true;
                errors.setPasswordErr("Password can not be blank");
            }
            if(phoneNumber.trim().length() == 0 || phoneNumber.trim().length() !=10 || !phoneNumber.matches("^[0-9]*$")){
                error = true;
                errors.setPhoneNumber("Invalid Phone number");
            }
            if(!error){
                
                AccountDAO dao = new AccountDAO();
                boolean result = dao.insert(id, password, fullName, address, phoneNumber);
                if(result){
                    url = SUCCESS;
                }
                
            }
            else{
                request.setAttribute("INVALIDRES", errors);
                
            }
            
            
        
        }     
        catch(Exception e){
            log("ERROR at RegisterServlet " + e.getMessage());
            if(e.getMessage().contains("duplicate")){
                errors.setIdDup(id + " already exist");
                
                request.setAttribute("INVALIDRES", errors);
            }
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
