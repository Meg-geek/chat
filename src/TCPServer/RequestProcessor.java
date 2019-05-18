package TCPServer;

import java.net.Socket;

public class RequestProcessor implements Runnable {
    private Socket clientSocket;
    private volatile boolean running = true;

    public RequestProcessor(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        while(running){

        }
    }
}
