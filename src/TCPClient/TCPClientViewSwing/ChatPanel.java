package TCPClient.TCPClientViewSwing;

import TCPClient.TCPClient;
import TCPServer.Message;
import TCPServer.MessagesStory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.Writer;

public class ChatPanel extends JPanel {
    private static final Color backgroundColor = new Color(204, 255, 153);
    private static final int MESSAGE_FIELD_HEIGHT = ChatFrame.USER_FONT_SIZE*2;
    private static final int USERS_LIST_WIDTH = ChatFrame.USER_FONT_SIZE * 15;
    private static final int USERS_LIST_HEIGHT = ChatFrame.FRAME_HEIGHT - MESSAGE_FIELD_HEIGHT*4;
    private static final int MESSAGES_WINDOW_HEIGHT = USERS_LIST_HEIGHT;
    private static final int MESSAGES_WINDOW_WIDTH = ChatFrame.FRAME_WIDTH - USERS_LIST_WIDTH;
    private JScrollPane messagesScrollPane;
    private JTextArea messagesArea;
    private JTextArea inputArea;
   // private Writer socketWriter;

    public ChatPanel(MessagesStory story){
        super();
        this.setOpaque(true);
        this.setBackground(backgroundColor);
        this.setSize(ChatFrame.FRAME_WIDTH, ChatFrame.FRAME_HEIGHT);
        this.setLayout(null);
        showStory(story);
        //socketWriter = writer;
        addInputField();
    }

    private void showStory(MessagesStory story){
       messagesArea = new JTextArea();
       messagesArea.setEditable(false);
       messagesArea.setFont(ChatFrame.userFont);
       for(Message message : story.getMessagesQueue()){
           messagesArea.append(message.getChatMessage() + System.lineSeparator());
       }
       messagesScrollPane = new JScrollPane(messagesArea);
       this.add(messagesScrollPane);
       messagesScrollPane.setBounds(10,10,MESSAGES_WINDOW_WIDTH,MESSAGES_WINDOW_HEIGHT);
    }

    public void addMessage(Message newMessage){
        messagesArea.append(newMessage.getChatMessage());
    }

    private void addInputField(){
        inputArea = new JTextArea();
        inputArea.setFont(ChatFrame.userFont);
        JScrollPane inputPane = new JScrollPane(inputArea);
        this.add(inputPane);
        inputPane.setBounds(10,MESSAGES_WINDOW_HEIGHT + 10, MESSAGES_WINDOW_WIDTH, ChatFrame.USER_FONT_SIZE*3);
        JButton sendButton = new JButton("SEND");
        this.add(sendButton);
        sendButton.setBounds(10 + MESSAGES_WINDOW_WIDTH, MESSAGES_WINDOW_HEIGHT + 10, ChatFrame.USER_FONT_SIZE*5,
                ChatFrame.USER_FONT_SIZE*3);
        sendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String message = inputArea.getText();
                try{
                    TCPClient.sendMessage(message);
                } catch(IOException ex){
                    TCPClient.infoException(ex);
                }
            }
        });
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
    }
}
