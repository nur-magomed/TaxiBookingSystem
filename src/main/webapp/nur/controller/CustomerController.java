package controller;

import dao.CustomerDAO;
import dao.ICustomerDAO;
import model.CustomerBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by nur on 27.10.16.
 */
@WebServlet(name = "CustomerController",  urlPatterns = {"/CustomerController"})
public class CustomerController extends HttpServlet {

    private ICustomerDAO customerDAO;
    public CustomerController() {
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            CustomerBean customerBean = new CustomerBean();
            customerBean.setFirst_name(request.getParameter("firstName"));
            customerBean.setLast_name(request.getParameter("lastName"));
            customerBean.setPhone_number(request.getParameter("phone_numb"));
            customerBean.setEmail(request.getParameter("email"));
            customerBean.setPassword(request.getParameter("user_password"));

            customerDAO.addCustomer(customerBean);
            out.println("<h1>You are registered</h1>");
            response.sendRedirect("welcome.jsp"); //logged-in page
        }catch (Throwable theException)
        {
            out.println("<h1> error:" + theException + "</h1>");
            out.println(theException);
        }


    }


}