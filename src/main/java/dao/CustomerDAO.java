package dao;

import com.crm.database.DBConnection; // Import the DBConnection class
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    public List<String> getAllCustomers() {
        List<String> customers = new ArrayList<>();
        try (Connection conn = DBConnection.createConnection()) {
            String query = "SELECT name FROM customers";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                customers.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
}
