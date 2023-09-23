package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static utils.ConfigReader.getValues;

//Throw exception early and catch later...
public interface CommonDAO {

    public static Connection createConnection() throws ClassNotFoundException, SQLException {

        Class.forName(getValues("DRIVER")); // loading driver

        final String CONNECT_STRING = getValues("CONNECTION_URL");
        final String USER_ID = getValues("USER_ID");
        final String PASSWORD = getValues("PASSWORD");
        Connection connect = DriverManager.getConnection(CONNECT_STRING, USER_ID, PASSWORD); // making a connection

//        if (connect != null) {
//            System.out.println("Connection Established :)");
//            connect.close();
//        } // checking if connection established successfully
        return connect;
    }
}