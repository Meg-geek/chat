package TCPServer;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.List;

/**
 * класс, который хранит историю последних сообщений
 * число сообщений - параметр конструктора
 */

public class MessagesStory implements Serializable {
    private int maxAmount;
    private ArrayDeque<Message> messagesQueue = new ArrayDeque<>();

    public MessagesStory(int maxAmount){
        this.maxAmount = maxAmount;
    }
    /*
    * метод, который добавляет новое сообщение в очередь сообщений,
    * если сообщений больше нужного количества, старое сообщение удаляется
    */
    public synchronized void addMessage(Message newMessage){
        if(maxAmount >= messagesQueue.size()){
            messagesQueue.pollFirst();
        }
        messagesQueue.addLast(newMessage);
    }

//    private void writeObject(java.io.ObjectOutputStream stream)
//            throws IOException {
//        for(String message: messagesQueue){
//            stream.writeObject(message);
//        }
//    }

    public void printMassagesList(Writer writer) throws IOException{
        for (Message message: messagesQueue){
            message.printMessage(writer);
        }
    }
}
