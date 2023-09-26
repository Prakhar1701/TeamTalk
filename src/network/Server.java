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
        Socket clientSocket = serverSocket.accept(); //HankShaking

        ServerWorker serverWorker = new ServerWorker(clientSocket);
        serverWorker.start();
    }

    // Multiple Client HandShaking
    public void handleClientRequest() {

    }

    /*
   // Single Client

    public Server() throws IOException {
        final int PORT = Integer.parseInt(ConfigReader.getValues("PORT_NUMBER"));
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server started and waiting for the client to connect...");
        Socket socket = serverSocket.accept(); //HankShaking

        System.out.println("Client connected..");

        InputStream in = socket.getInputStream();

        byte[] arr = in.readAllBytes();
        String message = new String(arr);
        System.out.println("Message from client: " + message);

        in.close();
        socket.close();
        System.out.println("Server closed...");
    }
    */

//    public static void main(String[] args) throws IOException {
//        new Server();
//    }
}
