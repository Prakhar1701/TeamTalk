package network;

import utils.ConfigReader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;

    public Server() throws IOException {
        final int PORT = Integer.parseInt(ConfigReader.getValues("PORT_NUMBER"));
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server started and waiting for the client to connect...");
        Socket socket = serverSocket.accept(); //HankShaking
        System.out.println("Client connected..");
        socket.close();
        System.out.println("Server closed...");
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}
