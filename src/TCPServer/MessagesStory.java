package TCPServer;

import java.util.ArrayDeque;
import java.util.List;

/**
 * класс, который хранит историю последних сообщений
 * число сообщений - параметр конструктора
 */

public class MessagesStory {
    private int maxAmount;
    private ArrayDeque<String> messagesQueue = new ArrayDeque<>();

    public MessagesStory(int maxAmount){
        this.maxAmount = maxAmount;
    }
    /*
    * метод, который добавляет новое сообщение в очередь сообщений,
    * если сообщений больше нужного количества, старое сообщение удаляется
    */
    public synchronized void addMessage(String newMessage){
        if(maxAmount >= messagesQueue.size()){
            messagesQueue.pollFirst();
        }
        messagesQueue.addLast(newMessage);
    }

    public void printMassagesList(){

    }
}
