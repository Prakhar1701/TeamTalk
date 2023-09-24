package network;

import utils.ConfigReader;

import java.io.IOException;
import java.net.Socket;

public class Client {
    Socket socket;

    public Client() throws IOException {
        final String IP = ConfigReader.getValues("SERVER_IP");
        final int PORT = Integer.parseInt(ConfigReader.getValues("PORT_NUMBER"));
        socket = new Socket(IP, PORT);
        System.out.println("Client is active...");
        socket.close();
        System.out.println("Client exits...");
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }
}
