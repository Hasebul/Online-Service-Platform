package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    public static final String url = "jdbc:postgresql://localhost/ShebaXYZ";
    public static final String user = "postgres";
    public static final String password = "1234";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    public  static void close(Connection c) {
        try {
            c.close();
            System.out.println("close succesfully");
        } catch (SQLException e) {
            System.out.println("error in close operation");
            e.printStackTrace();
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //connect();
       // System.out.println("\"user\"");

    }
}

