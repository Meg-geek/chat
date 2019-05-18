package TCPServer;

import ChatExceptions.PropertyFileException;
import PropertyFileHandler.PropertyFileHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class TCPServer {
    private static boolean needLog;
    private static Logger logger = LogManager.getLogger();
    public static List<ReqProcessorSerializIO> serverList = new LinkedList<>();
    public static MessagesStory story;
    private static LinkedList<String> logins = new LinkedList<>();

    public static void main(String[] args) throws IOException, PropertyFileException {
        needLog = PropertyFileHandler.getInstance()
                .getBooleanValue("LogServer");
        story = new MessagesStory(PropertyFileHandler.getInstance()
                .getIntegerValue("MessagesStartAmount"));
        ServerSocket serverSocket = new ServerSocket(PropertyFileHandler.getInstance()
                .getIntegerValue("SERVER_PORT"));
        if(needLog){
            logInfo("Server started working.");
        }
        while(true) {
            Socket clientSocket = serverSocket.accept();
            if(needLog){
                logInfo("Connection established with " + clientSocket.getInetAddress() + "port: " + clientSocket.getPort());
            }
            ReqProcessorSerializIO userThread = new ReqProcessorSerializIO(clientSocket);
            serverList.add(userThread);
            if(needLog){
                logInfo("Server started working with user");
            }
            userThread.start();
        }
    }

    private static void logInfo(String info){
        logger.info(info);
    }

    public static void logError(String errorInfo){
        logger.error(errorInfo);
    }
    //в дальнейшем переделать
    public static void registerLogin(String login){
        logins.add(login);
    }
}
