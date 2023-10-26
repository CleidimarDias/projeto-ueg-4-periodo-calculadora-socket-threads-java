package calculadora;

import java.io.*;
import java.net.*;

public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Escolha a operação:");
        System.out.println("1. Adicao");
        System.out.println("2. Subtracaio");
        System.out.println("3. Multiplicacao");
        System.out.println("4. Divisao");

        int choice = Integer.parseInt(userInput.readLine());
        int port;

        String operation;

        switch (choice) {
            case 1:
                port = 12345; // Porta para adição
                operation = "add";                   
                break;
            case 2:
                port = 12346; // Porta para subtração
                operation = "subtract";
                break;
            case 3:
                port = 12347; // Porta para multiplicação
                operation = "multiply";
                break;
            case 4:
                port = 12348; // Porta para divisão
                operation = "divide";
                break;
            default:
                System.out.println("Escolha inválida.");
                return;
        }

        Socket socket = new Socket("localhost", port);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Envie a operação ao servidor
        out.println(operation);

        System.out.print("Digite o primeiro numero: ");
        double num1 = Double.parseDouble(userInput.readLine());
        out.println(Double.toString(num1));

        System.out.print("Digite o segundo numero: ");
        double num2 = Double.parseDouble(userInput.readLine());
        out.println(Double.toString(num2));

        String response = in.readLine();
        System.out.println( response);

        socket.close();
    }
}





