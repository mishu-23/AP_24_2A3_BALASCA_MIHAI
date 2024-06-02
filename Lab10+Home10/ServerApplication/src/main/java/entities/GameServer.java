package entities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

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
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.start();
            } catch (IOException e) {
                if (isStopped) {
                    System.out.println("Server stopped.");
                    break;
                }
                e.printStackTrace();
            }
            stop();

        }
    }

    public synchronized void stop() {
        isStopped = true;
        try {
            serverSocket.close();
            for (ClientThread clientThread : clientThreads) {
                clientThread.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GameServer server = new GameServer(8002);
        server.start();
    }
}
