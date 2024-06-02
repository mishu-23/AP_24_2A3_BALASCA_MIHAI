package entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        out.println(msg);
        try {
            String response = in.readLine();
            System.out.println("Server response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GameClient client = new GameClient();
        client.startConnection("127.0.0.1", 8002);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        try {
            while ((command = consoleReader.readLine()) != null) {
                if (command.equalsIgnoreCase("exit")) {
                    client.stopConnection();
                    break;
                }
                client.sendMessage(command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}