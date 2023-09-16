package views;

import javax.swing.*;
import java.awt.*;

public class UserView extends JFrame {

    public UserView() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setTitle("Login");
//        setLocation(500, 150);
        setLocationRelativeTo(null);

        JLabel welcome = new JLabel("Login");
        welcome.setFont(new Font("Arial", Font.BOLD, 40));
        Container container = this.getContentPane();
        container.setLayout(null);
        welcome.setBounds(100, 70, 200, 60);
        container.add(welcome);
        setVisible(true);
    }

    public static void main(String[] args) {
        UserView userView = new UserView();
    }
}