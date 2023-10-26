package calculadora;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private String operation;
    private int port;


    public ClientHandler(Socket socket, String operation, int port) {
        this.socket = socket;
        this.operation = operation;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String operation = in.readLine();

            double result = 0;

            if (operation.equals("add")) {
                double num1 = Double.parseDouble(in.readLine());
                double num2 = Double.parseDouble(in.readLine());
                result = num1 + num2;
            } else if (operation.equals("subtract")) {
                double num1 = Double.parseDouble(in.readLine());
                double num2 = Double.parseDouble(in.readLine());
                result = num1 - num2;
            } else if (operation.equals("multiply")) {
                double num1 = Double.parseDouble(in.readLine());
                double num2 = Double.parseDouble(in.readLine());
                result = num1 * num2;
            } else if (operation.equals("divide")) {
                double num1 = Double.parseDouble(in.readLine());
                double num2 = Double.parseDouble(in.readLine());
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    out.println("Erro: Divisão por zero.");
                    socket.close();
                    return;
                }
            }

            out.println("Resultado: " + result + " (Servidor: " + operation + ", Porta: " + port + ")");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


