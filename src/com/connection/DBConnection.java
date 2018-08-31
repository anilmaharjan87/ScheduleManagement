package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection con = null;
    private static String url = "jdbc:mysql://localhost/timetablecollege"; //MySQL URL followed by the database name
    private static String username = "root"; //MySQL username
    private static String password = ""; //MySQL password


    public static Connection openConnection(){
        try
        {
            try
            {
                java.lang.Class.forName("com.mysql.cj.jdbc.Driver"); //loading MySQL drivers.
                System.out.println("Driver loaded");
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }

            con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
            System.out.println("Printing connection object "+con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("connection establish");
        return con;
    }
}

