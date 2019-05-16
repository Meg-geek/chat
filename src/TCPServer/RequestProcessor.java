package TCPServer;

import java.net.Socket;

public class RequestProcessor implements Runnable {
    private Socket clientSocket;


    public RequestProcessor(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

    }
}
