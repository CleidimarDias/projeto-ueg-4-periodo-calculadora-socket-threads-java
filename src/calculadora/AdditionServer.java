package calculadora;

import java.io.*;
import java.net.*;

public class AdditionServer {
    public static void main(String[] args) {
        int port = 12345; // Porta para adição

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor de adição está em execução na porta " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexão aceita de " + clientSocket.getInetAddress());

                // Crie uma instância do ClientHandler para a adição
                ClientHandler clientHandler = new ClientHandler(clientSocket, "add", port);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



