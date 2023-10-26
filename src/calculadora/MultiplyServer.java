package calculadora;

import java.io.*;
import java.net.*;

public class MultiplyServer {
    public static void main(String[] args) {
        int port = 12347; // Porta para Multiplicação

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor de Multiplicação está em execução na porta " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexão aceita de " + clientSocket.getInetAddress());

                // Crie uma instância do ClientHandler para a multiplicação
                ClientHandler clientHandler = new ClientHandler(clientSocket, "multiply", port);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


