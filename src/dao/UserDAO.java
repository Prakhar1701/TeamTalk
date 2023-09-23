package dao;

import dto.UserDTO;
import utils.Encryption;

import java.sql.*;

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

    public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException, Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String QUERY = "SELECT userId FROM users WHERE userId=? AND password=?";
        try {
            connection = CommonDAO.createConnection();
            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, userDTO.getUserId());
            preparedStatement.setString(2, Encryption.passwordEncrypt(userDTO.getPassword()));
            resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }

    }
}
