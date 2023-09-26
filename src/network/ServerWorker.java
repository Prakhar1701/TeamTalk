package network;

import java.io.*;
import java.net.Socket;

public class ServerWorker extends Thread {

    private Socket clientSocket;
    private InputStream in;
    private OutputStream out;

    public ServerWorker(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        in = clientSocket.getInputStream();
        out = clientSocket.getOutputStream();
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;

        try {
            while (true) {
                line = br.readLine();
                if (line.equalsIgnoreCase("quit")) break;
                out.write(line.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                if (in != null) in.close();
                if (out != null) out.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
