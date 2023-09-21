package views;

import javax.swing.*;
import java.awt.*;

public class UserScreen extends JFrame {
    private JTextField userIdTextField;
    private JTextField passwordTextField;

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

        passwordTextField = new JTextField();
        passwordTextField.setFont(new Font("Dialog", Font.PLAIN, 18));
        passwordTextField.setBounds(318, 283, 342, 43);
        getContentPane().add(passwordTextField);
        passwordTextField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        passwordLabel.setBounds(122, 290, 119, 36);
        getContentPane().add(passwordLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 18));
        loginButton.setBounds(187, 389, 195, 73);
        getContentPane().add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Dialog", Font.BOLD, 18));
        registerButton.setBounds(487, 389, 195, 73);
        getContentPane().add(registerButton);
        setBounds(100, 100, 871, 585);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
