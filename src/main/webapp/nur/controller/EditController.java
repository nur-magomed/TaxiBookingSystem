package controller;

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
 * Created by nur on 30.10.16.
 */
@WebServlet(name = "EditController", urlPatterns = "/EditController")
public class EditController extends HttpServlet {
    private ICustomerDAO customerDAO;
    public EditController() {
        customerDAO = new CustomerDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            CustomerBean currentCustomer = new CustomerBean();
            currentCustomer.setCustomer_id(((CustomerBean) request.getSession().getAttribute("currentSessionCustomer")).getCustomer_id());

            currentCustomer.setFirst_name(request.getParameter("firstName"));
            currentCustomer.setLast_name(request.getParameter("lastName"));
            currentCustomer.setPhone_number(request.getParameter("phone_numb"));
            currentCustomer.setEmail(request.getParameter("email"));
            currentCustomer.setPassword(request.getParameter("user_password"));
            currentCustomer.setGender(Integer.parseInt(request.getParameter("gender")));
            currentCustomer.setAddress_1(request.getParameter("address1"));
            currentCustomer.setAddress_2(request.getParameter("address2"));

            customerDAO.updateCustomer(currentCustomer);
            out.println("<h1>You are updated</h1>");
            HttpSession session = request.getSession();
           session.setAttribute("currentSessionCustomer", currentCustomer);
            response.sendRedirect("welcome.jsp"); //logged-in page
        }catch (Throwable theException)
        {
            out.println("<h1> error:" + theException + "</h1>");
            out.println(theException);
        }

    }
}
