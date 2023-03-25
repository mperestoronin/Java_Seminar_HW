package org.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiThreadedChatServer {
    private ServerSocket serverSocket;
    private List<ClientHandler> clients = new ArrayList<>();
    private int clientCount = 0;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket);
                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                Thread thread = new Thread(clientHandler);
                thread.start();
                clientCount++;
                System.out.println("Client " + clientCount + " connected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    private void removeClient(ClientHandler client) {
        clients.remove(client);
        System.out.println("Client disconnected: " + client.getSocket());
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private DataInputStream input;
        private DataOutputStream output;
        private String name;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Socket getSocket() {
            return socket;
        }

        public void sendMessage(String message) {
            try {
                output.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String getName() {
            return name;
        }

        @Override
        public void run() {
            try {
                output.writeUTF("");
                name = input.readUTF();
                broadcastMessage(name + " joined the chat.", this);

                String message;
                do {
                    message = input.readUTF();
                    broadcastMessage(name + ": " + message, this);
                } while (!message.equals("bye"));

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                removeClient(this);
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MultiThreadedChatServer server = new MultiThreadedChatServer();
        server.start(1234);
    }
}
