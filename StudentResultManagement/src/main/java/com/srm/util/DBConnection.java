package com.srm.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/srm_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null) {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("DB Connected Successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

