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
import sample.account.AccountDTO;
import sample.account.UpdateErr;

/**
 *
 * @author Phung Nguyen
 */
public class UpdateAccountCusServlet extends HttpServlet {
     private static final String ERRORS = "errors.jsp";
    private static final String INVALID = "profileCustom.jsp";
    private static final String SUCCESS = "UpdateProfileCusSuccess.jsp";
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
        try {
            String id = request.getParameter("txtAcountID");
          
            String password = request.getParameter("txtPassword");
            String fullName = request.getParameter("txtFullName");
            String address = request.getParameter("txtAddress");
            String phoneNumber = request.getParameter("txtPhone");
            String role = request.getParameter("txtRoleID");
            String status = request.getParameter("txtStatus");
            AccountDTO dto = new AccountDTO(id, password, fullName, address, phoneNumber, role, status);
            UpdateErr errors = new UpdateErr();
            
            boolean error = false;
            if(password.trim().length() == 0){
                error = true;
                errors.setPasswordErr("Password can not blank");
            }
            if(fullName.trim().length() == 0){
                error = true;
                errors.setFullNameErr("Full Name can not blank");
            }
            if(address.trim().length()==0){
                error = true;
                errors.setAddressErr("Address can not blank");
            }
            if(phoneNumber.trim().length() == 0 ||phoneNumber.trim().length()!= 10 || !phoneNumber.matches("^[0-9]*$")){
                error = true;
                errors.setPhoneNumberErr("Phone number Invalid");
            }
             if(!error){
                 AccountDAO dao = new AccountDAO();
                 boolean result = dao.update(id, password, fullName, address, phoneNumber);
                 if(result){
                     url = SUCCESS;
                 }
                 else{
                     request.setAttribute("ERRORS", "Update failed");
                 }
                 
                 
                 
             }   
             else{
                 request.setAttribute("UPDATEACCOUNTERR", errors);
                 request.setAttribute("INFO", dto);
                 url = INVALID;
             }
            
            
            
        }
        catch(Exception e){
            log("ERROR at UpdateAccountServlet "  +e.getMessage());
         
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
