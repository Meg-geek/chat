package TCPServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ReqProcessorSerializIO extends Thread {
    private Socket clientSocket;
    private volatile boolean running = true;
    private ObjectOutputStream objectWriter;
    private ObjectInputStream objectReader;

    public ReqProcessorSerializIO(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            objectWriter = new ObjectOutputStream(clientSocket.getOutputStream());
            objectReader = new ObjectInputStream(clientSocket.getInputStream());
            String login = (String)objectReader.readObject();
            TCPServer.registerLogin(login);
            while(running){
                Message message = (Message) objectReader.readObject();
                TCPServer.story.addMessage(message);
                for (ReqProcessorSerializIO userThread : TCPServer.serverList){
                    userThread.sendMessage(message);
                }
            }
        } catch(IOException|ClassNotFoundException ex) {
            TCPServer.logError(ex.getMessage());
        } finally {
            try{
                objectWriter.close();
                objectReader.close();
            } catch (IOException ex){
                TCPServer.logError(ex.getMessage());
            }


        }
    }

    public void sendMessage(Message message) throws IOException{
        objectWriter.writeObject(message);
        objectWriter.flush();
    }
}
