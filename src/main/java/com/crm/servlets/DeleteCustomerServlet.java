package com.crm.servlets;

import com.crm.dao.CustomerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); // Get customer ID from request

        CustomerDAO dao = new CustomerDAO();
        dao.deleteCustomer(id); // Call DAO method to delete the customer

        response.sendRedirect("ViewCustomersServlet"); // Redirect to view updated list
    }

}
