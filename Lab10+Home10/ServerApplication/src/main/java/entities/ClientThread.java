package entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private final Socket clientSocket;
    private final GameServer server;
    private PrintWriter out;


    public ClientThread(Socket socket, GameServer   server) {
        this.clientSocket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);
                if (request.equalsIgnoreCase("stop")) {
                    out.println("Server stopped");
                    server.stop();
                    break;
                } else if (request.equalsIgnoreCase("create game")){
                    Table table = new Table();
                    //pune fiecare player sa isi puna navele
                } else {
                    out.println("Server received the request: " + request);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void sendMessage(String message) {
        if (out != null) {
            out.println(message);
        }
    }

    public void close() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
