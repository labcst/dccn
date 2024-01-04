import java.net.*;
import java.io.*;

public class Server {
    private ServerSocket serverSocket = null;
    private Socket clientSocket = null;
    private DataInputStream in = null;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");

            clientSocket = serverSocket.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));

            String line = "";
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            System.out.println("Closing connection");
            clientSocket.close();
            in.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        Server server = new Server(5000);
    }
}

