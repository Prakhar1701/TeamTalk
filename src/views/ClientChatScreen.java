package views;

import network.Client;
import utils.UserInfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientChatScreen extends JFrame {

    private final JPanel contentPane;
    private final JTextField messageTextField;
    private final JTextArea textArea;
    private final Client client;

    public ClientChatScreen() throws IOException {
        setTitle("TeamTalk");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1143, 752);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 12, 1120, 566);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        textArea.setFont(new Font("Dialog", Font.PLAIN, 20));
        textArea.setBounds(30, 30, 1044, 487);
        scrollPane.setViewportView(textArea);

        messageTextField = new JTextField();
        messageTextField.setFont(new Font("Dialog", Font.PLAIN, 20));
        messageTextField.setBounds(38, 609, 836, 59);
        contentPane.add(messageTextField);
        messageTextField.setColumns(10);

        JButton sendButton = new JButton("SEND");
        sendButton.addActionListener(e -> sendMessage());
        sendButton.setFont(new Font("Dialog", Font.BOLD, 20));
        sendButton.setBounds(922, 609, 184, 59);
        contentPane.add(sendButton);
        setVisible(true);

        client = new Client(textArea);
    }

    public static void main(String[] args) {
        try {
            ClientChatScreen frame = new ClientChatScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessage() {
        String message = messageTextField.getText();
        try {
            client.sendMessage(UserInfo.USER_ID + " -> " + message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
