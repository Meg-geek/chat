package TCPServer;

import ChatExceptions.PropertyFileException;
import PropertyFileHandler.PropertyFileHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException, PropertyFileException {
        ServerSocket serverSocket = new ServerSocket(PropertyFileHandler.getInstance()
                .getValue("SERVER_PORT"));
        while(true) {
            Socket clientSocket = serverSocket.accept();
        }
    }
}
