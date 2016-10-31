package controller;

import dao.CustomerDAO;
import dao.ICustomerDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by nur on 30.10.16.
 */
@WebServlet(name = "LogoutController", urlPatterns = "/LogoutController")
public class LogoutController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LogoutController.class);
    private ICustomerDAO customerDAO;
    public LogoutController() {
        customerDAO = new CustomerDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();



        customerDAO.closeConnection();
        log.warn("The connection with DB is closed");
        request.getSession().invalidate();
        log.warn("The session is has closed");
        log.warn("Redirecting to login page");
        response.sendRedirect("index.jsp"); //logged-in page
    }



}
