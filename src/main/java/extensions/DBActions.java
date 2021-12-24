package extensions;

import Utilities.CommonOps;
import io.qameta.allure.Step;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {
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

    @Step ("Get username from DB")
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

    @Step ("Get password from DB")
    public static String getPassword() {
        try {
            rs= stmt.executeQuery("SELECT password FROM Login");
            rs.next();
            return rs.getString(1);
        }
        catch(SQLException e) {
            System.out.println("Error occurred while printing table data, see details: " + e);
        }
        return "";
    }

    @Step ("Closing connection to the DB")
    public static void closeDBCon() {
        try {
            con.close();
        }
        catch(SQLException e) {
            System.out.println("Error Occured While Closing JDBC, See Details: " + e);
        }
    }
}
