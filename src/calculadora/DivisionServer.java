package calculadora;

import java.io.*;
import java.net.*;

public class DivisionServer {
    public static void main(String[] args) {
        int port = 12348; // Porta para Divisão

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor de Divisão está em execução na porta " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexão aceita de " + clientSocket.getInetAddress());

                // Crie uma instância do ClientHandler para a Divisão
                ClientHandler clientHandler = new ClientHandler(clientSocket, "divide", port);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

