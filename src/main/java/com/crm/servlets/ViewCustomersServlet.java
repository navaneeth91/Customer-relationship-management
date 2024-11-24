package com.crm.servlets;
import com.crm.dao.CustomerDAO;
import com.crm.model.Customer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
@WebServlet("/ViewCustomersServlet")
public class ViewCustomersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO dao = new CustomerDAO();
        List<Customer> customers = dao.getAllCustomers();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);
    }
}
