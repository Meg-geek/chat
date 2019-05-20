package TCPServer;

import ChatExceptions.PropertyFileException;
import PropertyFileHandler.PropertyFileHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class TCPServer {
    private static boolean needLog;
    private static Logger logger = LogManager.getLogger();

    private static LinkedList<ReqProcessorSerializIO> serverList = new LinkedList<ReqProcessorSerializIO>();

    private static Map loginClientSyncMap = Collections.synchronizedMap(new HashMap<Thread, String>());
    private static MessagesStory story;
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
    public static void registerLogin(String login, ReqProcessorSerializIO userThread){
       // logins.add(login);
        loginClientSyncMap.put(userThread, login);
        synchronized (story){
            story.addMessage(new Message("SERVER", login + " has just connected"));
        }
    }

    public static void sendMessageToAll(Message message) throws IOException{
        synchronized (story){
            story.addMessage(message);
        }
        synchronized (serverList){
            for (ReqProcessorSerializIO userThread : serverList){
                userThread.sendMessage(message);
            }
        }
    }

    public static void removeClient(ReqProcessorSerializIO clientToRemove){
        synchronized (serverList){
            serverList.remove(clientToRemove);
        }
        loginClientSyncMap.remove(clientToRemove);
    }

    public static void sendStory(ReqProcessorSerializIO userThread) throws IOException{
        userThread.sendStory(story);
    }
}
