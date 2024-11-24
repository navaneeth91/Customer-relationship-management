package com.crm.servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.crm.bean.LoginBean;
import com.crm.dao.LoginDao;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("Inside servlet");
        LoginBean loginBean = new LoginBean();

        loginBean.setEmail(email);
        loginBean.setPassword(password);

        LoginDao loginDao = new LoginDao();

        try
        {
            String userValidate = loginDao.authenticateUser(loginBean);

            if(userValidate.equals("admin"))
            {
                System.out.println("Admin's Home");

                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("Admin", email); //setting session attribute
                request.setAttribute("email", email);

                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            }
           /* else if(userValidate.equals("Employee"))
            {
                System.out.println("Employee's Home");

                HttpSession session = request.getSession();
                session.setAttribute("Employee", email);
                request.setAttribute("email", email);

                request.getRequestDispatcher("/JSP/Employee.jsp").forward(request, response);
            }
            else if(userValidate.equals("User"))
            {
                System.out.println("User's Home");

                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10*60);
                session.setAttribute("User", email);
                request.setAttribute("email", email);

                request.getRequestDispatcher("/JSP/User.jsp").forward(request, response);
            }*/
            else
            {
                System.out.println("Error message = "+userValidate);
                request.setAttribute("errMessage", userValidate);

                request.getRequestDispatcher("/JSP/index.jsp").forward(request, response);
            }
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
    } //End of doPost()
}
