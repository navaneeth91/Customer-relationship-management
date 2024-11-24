package com.crm.test;

import com.crm.database.DBConnection; // Ensure this is your DBConnection class package
import java.sql.Connection;

public class TestDBConnection {
    public static void main(String[] args) {
        try (Connection con = DBConnection.createConnection()) {
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}
