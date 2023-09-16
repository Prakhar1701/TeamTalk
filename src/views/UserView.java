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
        setVisible(true);
    }

    public static void main(String[] args) {
        UserView userView = new UserView();
    }
}