package dao;

import dto.UserDTO;
import utils.Encryption;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//Class to perform user CRUD operations.
public class UserDAO {

    public int add(UserDTO userDTO) throws SQLException, ClassNotFoundException, Exception {
        System.out.println(userDTO.getUserId() + " " + userDTO.getPassword());

        Connection connection = null;
        Statement statement = null;

        try {
            connection = CommonDAO.createConnection();

            statement = connection.createStatement();

            final String QUERY = "INSERT INTO users (userId, password) VALUES ('" + userDTO.getUserId() + "', '" + Encryption.passwordEncrypt(userDTO.getPassword()) + "')";
            int record = statement.executeUpdate(QUERY);  //Inset, Delete, Update

            return record;
        } finally { // Will not be executed only in the case of System.exit();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }
}
