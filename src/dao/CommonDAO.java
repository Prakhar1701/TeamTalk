package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonDAO {
    public CommonDAO() {
    }

    public Connection createConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver"); // loading driver

        final String CONNECT_STRING = "jdbc:mysql://localhost:3306/chatdb";
        final String USER_ID = "root";
        final String PASSWORD = "prakhar123";
        Connection connect = DriverManager.getConnection(CONNECT_STRING, USER_ID, PASSWORD); // making a connection

        if (connect != null) {
            System.out.println("Connection Established :)");
            connect.close();
        } // checking if connection established successfully
        return null;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CommonDAO cDAO = new CommonDAO();
        cDAO.createConnection();
    }
}