package views;

import dao.UserDAO;
import dto.UserDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserScreen extends JFrame {
    private JTextField userIdTextField;
    private JTextField passwordPasswordField;

    public static void main(String[] args) {
        UserScreen window = new UserScreen();
    }

    public UserScreen() {
        setResizable(false);
        setTitle("LOGIN");
        getContentPane().setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("LOGIN");
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(328, 55, 162, 73);
        getContentPane().add(lblNewLabel);

        JLabel userIdLabel = new JLabel("UserId");
        userIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userIdLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        userIdLabel.setBounds(122, 198, 91, 36);
        getContentPane().add(userIdLabel);

        userIdTextField = new JTextField();
        userIdTextField.setFont(new Font("Dialog", Font.PLAIN, 18));
        userIdTextField.setBounds(318, 196, 342, 43);
        getContentPane().add(userIdTextField);
        userIdTextField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        passwordLabel.setBounds(122, 290, 119, 36);
        getContentPane().add(passwordLabel);

        passwordPasswordField = new JPasswordField();
        passwordPasswordField.setFont(new Font("Dialog", Font.PLAIN, 18));
        passwordPasswordField.setBounds(318, 283, 342, 43);
        getContentPane().add(passwordPasswordField);
        passwordPasswordField.setColumns(10);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 18));
        loginButton.setBounds(187, 389, 195, 73);
        getContentPane().add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        registerButton.setFont(new Font("Dialog", Font.BOLD, 18));
        registerButton.setBounds(487, 389, 195, 73);
        getContentPane().add(registerButton);

        setSize(871, 585);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void register() {
        String userId = userIdTextField.getText();
        String password = passwordPasswordField.getText(); //unable to find method getPassword()

        UserDAO userDAO = new UserDAO();
        UserDTO userDTO = new UserDTO(userId, password);

        try {
            int result = userDAO.add(userDTO);
            if (result > 0) {
//                System.out.println("Added user successfully :)");
                JOptionPane.showMessageDialog(this, "Registered successfully.");
            } else {
//                System.out.println("Unable to add user :(");
                JOptionPane.showMessageDialog(this, "Registration unsuccessful.");

            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("DB Issue...");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Generic Issue...");
            e.printStackTrace(); // Tells where is the exception
        }
    }
}
