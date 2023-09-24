package network;

import utils.ConfigReader;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Socket socket;

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

    public static void main(String[] args) throws IOException {
        new Client();
    }
}
