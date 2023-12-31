package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DashBoard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public DashBoard(String title) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu chatMenu = new JMenu("Chat");
        menuBar.add(chatMenu);

        JMenuItem startChat = new JMenuItem("Start Chat");
        startChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ClientChatScreen();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        chatMenu.add(startChat);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        setTitle(title);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel imageLable = new JLabel("");

        imageLable.setSize(500, 500);

        imageLable.setHorizontalAlignment(SwingConstants.CENTER);
        imageLable.setVerticalAlignment(SwingConstants.CENTER);

        imageLable.setBackground(new Color(255, 255, 255));
        imageLable.setIcon(new ImageIcon(DashBoard.class.getResource("/images/people-team.jpg")));
        contentPane.add(imageLable, BorderLayout.CENTER);
    }
}
