package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RemoteDB {
    static String dbUrl = "jdbc:mysql://remotemysql.com:3306/o51EvpDF5Z";
    static String username = "o51EvpDF5Z";
    static String password = "ZvjcsQ9714";
    static ResultSet rs;
    static Connection con;
    static Statement stmt;

    public static void initSQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl,username,password);
            stmt = con.createStatement();
        }
        catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, See Details: " + e);
        }
    }

    public static String getUsername() {
        try {
            rs= stmt.executeQuery("SELECT username FROM Login");
            rs.next();
            return rs.getString(1);
        }
        catch(SQLException e) {
            System.out.println("Error Occured While Printing Table Data, See Details: " + e);
        }
        return "";
    }

    public static String getPassword() {
        try {
            rs= stmt.executeQuery("SELECT password FROM Login");
            rs.next();
            return rs.getString(1);
        }
        catch(SQLException e) {
            System.out.println("Error Occured While Printing Table Data, See Details: " + e);
        }
        return "";
    }

    public void closeDBCon() {
        try {
            con.close();
        }
        catch(SQLException e) {
            System.out.println("Error Occured While Closing JDBC, See Details: " + e);
        }
    }
}
