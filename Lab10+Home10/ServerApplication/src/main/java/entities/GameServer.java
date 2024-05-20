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
    private final Set<ClientThread> clientThreads = Collections.synchronizedSet(new HashSet<>());
    private final AtomicInteger clientIdCounter = new AtomicInteger(1);


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
                int clientId = clientIdCounter.getAndIncrement();
                ClientThread clientThread = new ClientThread(clientSocket, this, clientId);
                clientThreads.add(clientThread);
                clientThread.start();
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
            for (ClientThread clientThread : clientThreads) {
                clientThread.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message) {
        synchronized (clientThreads) {
            for (ClientThread clientThread : clientThreads) {
                clientThread.sendMessage(message);
                System.out.println(message + "was sent to client" + clientThread.getId());
            }
        }
    }

    public synchronized int getClientCount() {
        return clientThreads.size();
    }

    public static void main(String[] args) {
        GameServer server = new GameServer(8002);
        server.start();
    }
}
