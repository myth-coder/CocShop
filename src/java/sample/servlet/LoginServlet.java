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
import javax.servlet.http.HttpSession;
import sample.account.AccountDAO;
import sample.account.AccountErr;

/**
 *
 * @author Phung Nguyen
 */
public class LoginServlet extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String INVALID = "login.jsp";
    private static final String ADMIN = "admin.jsp";
    private static final String CUSTOMER = "customer.jsp";
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
           String username = request.getParameter("txtUsername");
           String password = request.getParameter("txtPassword");
            AccountErr errors = new AccountErr();
            boolean error = false;
            if(username.trim().length() == 0){
                errors.setNameErr("Username can not be blank");
                error = true;
            }
            if(password.trim().length() == 0){
                error = true;
                errors.setPasswordErr("Password can not be blank");
            }
           if(!error){
                AccountDAO dao = new AccountDAO();
                HttpSession session = request.getSession();
                session.setAttribute("USER", username);

                String roleID = dao.checkLogin(username, password);

                if(roleID.trim().equals("A")){
                    url = ADMIN;
                }
                else if(roleID.trim().equals("C")){
                    url =CUSTOMER;
                }
                else if(roleID.trim().equals("failed")){
                    request.setAttribute("ERROR", "Invalid username or password!");
                }
                else{
                    request.setAttribute("ERROR", "Your role is not support");
                }
           }
           else{
               request.setAttribute("INVALID", errors);
               url  = INVALID;
           }
           
           
            
            
            
        }
        catch(Exception e){
            log("ERROR at LoginServlet " + e.getMessage());
            
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
