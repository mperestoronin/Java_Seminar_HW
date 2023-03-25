package org.example;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 1234;
        try {
            // connect to the server
            Socket socket = new Socket(serverName, port);
            System.out.println("Connected to server " + serverName + ":" + port);

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read and print server's welcome message
            String welcomeMsg = in.readUTF();
            System.out.println(welcomeMsg);

            // read username from user input
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your username: ");
            String username = reader.readLine();

            // send username to server
            out.writeUTF(username);

            // create a separate thread to read messages from the server
            Thread readerThread = new Thread(() -> {
                while (true) {
                    try {
                        String message = in.readUTF();
                        System.out.println(message);
                    } catch (IOException e) {
                        System.err.println("Error reading from server: " + e.getMessage());
                        System.exit(1);
                    }
                }
            });
            readerThread.start();

            // read messages from user input and send them to the server
            while (true) {
                System.out.print("> ");
                String message = reader.readLine();
                out.writeUTF(message);
            }

        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
            System.exit(1);
        }
    }
}
