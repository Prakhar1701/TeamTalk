package network;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//Client worker to read data from server
public class ClientWorker extends Thread {

    private InputStream in;
    private JTextArea textArea;

    public ClientWorker(InputStream in, JTextArea textArea) {
        this.in = in;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while (true) {
                line = br.readLine();
                textArea.setText(textArea.getText() + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
