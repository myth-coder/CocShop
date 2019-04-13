
package sample.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Phung Nguyen
 */
public class OrderServlet extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginServlet";
    private static final String SEARCHBYNAME = "SearchProductByName.jsp";
    private static final String DELETE = "DeleteProductServlet";
    private static final String EDIT = "EditProductServlet";
    private static final String UPDATE = "UpdateProductServlet";
    private static final String CREATEPRODUCT = "CreatProduct.jsp";
    private static final String CREATE = "CreatProductServlet";
    private static final String SHOWINFO = "ShowInfoServlet";
    private static final String UPDATEACCOUNT = "UpdateAccountServlet";
    private static final String UPDATEACCOUNTCUS = "UpdateAccountCusServlet";
    private static final String DELETEACCOUNT = "DeleteAccountServlet";
    private static final String CHOICE = "choice.jsp";
    private static final String SEARCHBYPRICE = "SearchByPriceServlet";
    private static final String ADDITEM = "AddItemServlet";
    private static final String REMOVEITEM = "RemoveItemServlet";
    private static final String CHECKOUT = "CheckOutServlet";
    private static final String VIEWCART = "viewCart.jsp";
    private static final String CONFIRM = "ConfirmServlet";
    private static final String INFOCUSTOM = "showInfoCusServlet";
    private static final String CUSCHOICE = "cusChoice.jsp";
    private static final String REGISTER = "RegisterServlet";
    private static final String LOGOUT = "LogOutServlet";
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
        String button = request.getParameter("btnAction");
        try{
           if(button.equals("Login")){
               url  =LOGIN;
           }
           else if(button.equals("Search By Name")){
                url = SEARCHBYNAME;
           }
           else if(button.equals("Delete")){
               url = DELETE;
           }
           else if(button.equals("Edit")){
               url = EDIT;
           }
           else if(button.equals("Update")){
               url = UPDATE;
           }
           else if(button.equals("Create new Product")){
               url = CREATEPRODUCT;
           }
           else if(button.equals("Create")){
               url = CREATE;
           }
           else if(button.equals("My Profile")){
               url = SHOWINFO;
           }
           else if (button.equals("Update Account")){
               url = UPDATEACCOUNT;
           }
           else if(button.equals("Delete Account")){
               url = DELETEACCOUNT;
           }
           else if(button.equals("ask")){
               url = CHOICE;
           }
           else if(button.equals("ask1")){
               url = CUSCHOICE;
           }
           else if(button.equals("Search By Price")){
               url = SEARCHBYPRICE;
           }
           else if(button.equals("Buy")){
               url = ADDITEM;
           }
           else if(button.equals("Remove")){
               url = REMOVEITEM;
           }
           else if(button.equals("Check Out")){
               url = CHECKOUT;
           }
           else if(button.equals("View Cart")){
               url = VIEWCART;
           }
           else if(button.equals("Confirm")){
               url = CONFIRM;
           }
           else if(button.equals("View Profile")){
               url = INFOCUSTOM;
           }
           else if(button.equals("Update My Account")){
               url = UPDATEACCOUNTCUS;
           }
           else if(button.equals("LOG OUT")){
               url = LOGOUT;
           }
           else if(button.equals("Register")){
               url = REGISTER;
           }
           else{
                request.setAttribute("ERROR", "Action is not support");
            }
            
            
        }
        catch(Exception e){
            log("ERROR at OrderServlet " + e.getMessage());
          
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
