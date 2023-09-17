package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends JFrame {
    int counter;

    public UserView() throws HeadlessException {
        counter = 0;
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

        JButton button = new JButton("Count"); //Source
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcome.setText("Count: " + ++counter);
            }
        });
        button.setBounds(100, 300, 200, 50);
        container.add(button);

        setVisible(true);
    }

    public static void main(String[] args) {
        UserView userView = new UserView();
    }
}