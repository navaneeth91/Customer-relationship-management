package com.crm.servlets;

import com.crm.dao.CustomerDAO;
import com.crm.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        CustomerDAO dao = new CustomerDAO();
        Customer customer = dao.getCustomerById(id); // Fetch customer details by ID

        request.setAttribute("customer", customer);
        request.getRequestDispatcher("updateCustomer.jsp").forward(request, response); // Forward to update form
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);

        CustomerDAO dao = new CustomerDAO();
        dao.updateCustomer(customer); // Update customer in database

        response.sendRedirect("ViewCustomersServlet"); // Redirect to view customers
    }
}
