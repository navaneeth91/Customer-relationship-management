package com.crm.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.crm.bean.LoginBean;
import com.crm.database.DBConnection;
public class LoginDao {

    public String authenticateUser(LoginBean loginBean)
    {
        String email= loginBean.getEmail();
        String password = loginBean.getPassword();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String emailDB = "";
        String passwordDB = "";
        String roleDB = "";

        try
        {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select email,password,role from users");

            while(resultSet.next())
            {
                emailDB = resultSet.getString("email");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getString("role");

                if(email.equals(emailDB) && password.equals(passwordDB) && roleDB.equals("admin"))
                    return "admin";
                else if(email.equals(emailDB) && password.equals(passwordDB) && roleDB.equals("Employee"))
                    return "Employee";
                else if(email.equals(emailDB) && password.equals(passwordDB) && roleDB.equals("User"))
                    return "User";
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
}