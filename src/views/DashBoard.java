package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DashBoard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public DashBoard(String title) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
