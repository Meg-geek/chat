package TCPClient;

import ChatExceptions.PropertyFileException;
import PropertyFileHandler.PropertyFileHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient {
    private static Socket socket;

    public static void main(String[] args) throws IOException, PropertyFileException {
        socket = new Socket("localhost", PropertyFileHandler.getInstance()
                .getIntegerValue("SERVER_PORT"));
        useSerializationIO();
    }

    private static void useSerializationIO() throws IOException{
        ObjectOutputStream objectWriter = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectReader = new ObjectInputStream(socket.getInputStream());

    }
}
