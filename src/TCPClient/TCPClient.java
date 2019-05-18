package TCPClient;

import ChatExceptions.PropertyFileException;
import PropertyFileHandler.PropertyFileHandler;
import TCPClient.TCPClientViewSwing.ChatFrame;
import TCPServer.Message;
import TCPServer.MessagesStory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient {
    private static Socket socket;
    private static ChatFrame chatFrame = new ChatFrame();
    private static String login;
    private static ObjectOutputStream objectWriter;
    private static ObjectInputStream objectReader;

    public static void main(String[] args) throws IOException, PropertyFileException, ClassNotFoundException {
        socket = new Socket("localhost", PropertyFileHandler.getInstance()
                .getIntegerValue("SERVER_PORT"));
        useSerializationIO();
    }

    private static void useSerializationIO() throws IOException, ClassNotFoundException{
        objectWriter = new ObjectOutputStream(socket.getOutputStream());
        objectReader = new ObjectInputStream(socket.getInputStream());
        login = chatFrame.getLogin();
        if (login == null){
            closeTCPClient();
        }
        objectWriter.writeObject(login);
        MessagesStory story = (MessagesStory) objectReader.readObject();
        chatFrame.showChat(story);
        while(true){
            String newMessageString = chatFrame.getMessage();
        }
    }

    private static void closeTCPClient() throws IOException{
        socket.close();
        objectReader.close();
        objectWriter.close();
        System.exit(0);
    }
}
