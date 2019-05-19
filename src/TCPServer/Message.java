package TCPServer;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

public class Message implements Serializable {
    private String login;
    private String message;
    private String chatMessage;
    private boolean isExit = false;

    public Message(String login, String message){
        this.login = login;
        this.message = message;
        chatMessage = login + ": " + message;
        if (message.equals("exit")){
            isExit = true;
        }
    }

    public void printMessage(Writer writer) throws IOException {
        writer.write(chatMessage);
        writer.flush();
    }

    public String getChatMessage(){
        return chatMessage;
    }

    public boolean isExitMessage(){
        return isExit;
    }
}
