package network;

import utils.ConfigReader;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    Socket socket;
    InputStream in;
    OutputStream out;
    ClientWorker worker;
    JTextArea textArea;

    public Client(JTextArea textArea) throws IOException {
        final String IP = ConfigReader.getValues("SERVER_IP");
        final int PORT = Integer.parseInt(ConfigReader.getValues("PORT_NUMBER"));
        socket = new Socket(IP, PORT);


        in = socket.getInputStream();
        out = socket.getOutputStream();

        this.textArea = textArea;

        readMessages();
    }

    public void sendMessage(String message) throws IOException {
        message = message + "\n";
        out.write(message.getBytes());
    }

    public void readMessages() {
        worker = new ClientWorker(in, textArea);
        worker.start();
    }

   /*
   public Client() throws IOException {
        final String IP = ConfigReader.getValues("SERVER_IP");
        final int PORT = Integer.parseInt(ConfigReader.getValues("PORT_NUMBER"));
        socket = new Socket(IP, PORT);
        System.out.println("Client is active...");

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter message to send:");
        String message = scn.nextLine();
        OutputStream out = socket.getOutputStream();
        out.write(message.getBytes());

        out.close();
        socket.close();
        scn.close();
        System.out.println("Client exits...");
    }
    */

//    public static void main(String[] args) throws IOException {
//        new Client();
//    }
}
