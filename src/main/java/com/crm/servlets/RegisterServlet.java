package com.crm.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.dao.RegisterDao;
import com.crm.bean.RegisterBean;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super(); // Default no-argument constructor
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String Name = request.getParameter("name");
        String email = request.getParameter("email");
        String address=request.getParameter("address");
        String password = request.getParameter("password");
        String role = request.getParameter("user_type");
        String mobile = request.getParameter("mobile");

        RegisterBean registerBean=new RegisterBean();
        RegisterDao registerDao = new RegisterDao();
        registerBean.setName(Name);
        registerBean.setEmail(email);
        registerBean.setAddress(address);
        registerBean.setPassword(password);
        registerBean.setMobile(mobile);
        registerBean.setRole(role);

        try {
            registerDao.registerUser(registerBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }
}