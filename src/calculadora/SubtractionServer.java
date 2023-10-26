package calculadora;

import java.io.*;
import java.net.*;

public class SubtractionServer {
    public static void main(String[] args) {
        int port = 12346; // Porta para subtração

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor de Subtração está em execução na porta " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexão aceita de " + clientSocket.getInetAddress());

                // Crie uma instância do ClientHandler para a subtração
                ClientHandler clientHandler = new ClientHandler(clientSocket, "subtract", port);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



