package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {



    }
    public static Connection mySqlConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
