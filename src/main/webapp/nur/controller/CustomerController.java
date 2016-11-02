package controller;

import dao.CustomerDAO;
import dao.ICustomerDAO;
import model.CustomerBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by nur on 27.10.16.
 */
@WebServlet(name = "CustomerController",  urlPatterns = {"/CustomerController"})
public class CustomerController extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private ICustomerDAO customerDAO;
    public CustomerController() {
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            CustomerBean customerBean = new CustomerBean(request);
            log.info("Customer is created by the request");
            customerDAO.addCustomer(customerBean);
            log.info("Customer is added to the database");

            HttpSession session = request.getSession(true);
            session.setAttribute("currentSessionCustomer", customerBean);
            log.info("Session customer is set");
            log.info("Redirecting to WELCOME PAGE");
            response.sendRedirect("welcome.jsp"); //logged-in page
        }catch (Throwable theException)
        {
            log.error("Error in CustomerController" + theException);
            out.println(theException);
        }

    }
}