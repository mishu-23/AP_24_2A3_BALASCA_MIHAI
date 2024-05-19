package entities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private ServerSocket serverSocket;
    private boolean isStopped = false;

    public GameServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Game server started on port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (!isStopped) {
            try {
                Socket clientSocket = serverSocket.accept();
                new ClientThread(clientSocket, this).start();
            } catch (IOException e) {
                if (isStopped) {
                    System.out.println("Server stopped.");
                    break;
                }
                e.printStackTrace();
            }
        }
        stop();
    }

    public synchronized void stop() {
        isStopped = true;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GameServer server = new GameServer(8002);
        server.start();
    }
}
