package controller;

import com.sun.corba.se.impl.orbutil.ObjectUtility;
import dao.CustomerDAO;
import dao.ICustomerDAO;
import model.CustomerBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by nur on 28.10.16.
 */
@WebServlet(name = "LoginController",  urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private ICustomerDAO customerDAO;
    public LoginController() {
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out = response.getWriter();

        try {

            CustomerBean customerBean = new CustomerBean();
            customerBean.setEmail(request.getParameter("username"));
            customerBean.setPassword(request.getParameter("password"));

            /* Checking if the user exists, and returning customer if exist, null if doesn't exist*/
            customerBean = customerDAO.loginCheck(customerBean);
            if(customerBean!=null ){
                out.println("Welcome to Taxi booking System " + customerBean.getFirst_name() + "!");

                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionCustomer", customerBean);

                response.sendRedirect("welcome.jsp"); //logged-in page
            }
            else {
                out.println("Sorry, username or password was wrong.");
                out.println("Please, try again.");
                response.sendRedirect("index.jsp"); //logged-in page
            }
        }catch (Throwable theException)
        {
            out.println("<h1> error:" + theException + "</h1>");
            out.println(theException);
        }

    }

}
