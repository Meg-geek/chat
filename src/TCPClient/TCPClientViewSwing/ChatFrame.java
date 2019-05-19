package TCPClient.TCPClientViewSwing;

import TCPClient.TCPClient;
import TCPServer.Message;
import TCPServer.MessagesStory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.Writer;

public class ChatFrame {
    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 500;
    public static final int INFO_FONT_SIZE = FRAME_HEIGHT /20;
    public static final int USER_FONT_SIZE = FRAME_HEIGHT / 35;
    public static final Font infoFont = new Font("TimesRoman", Font.BOLD, INFO_FONT_SIZE);
    public static final Font userFont = new Font("Monospaced",Font.BOLD, USER_FONT_SIZE);

    private JFrame frame;
    private StartedPanel startedPanel;
    private ChatPanel chatPanel;
   // private Writer socketWriter;

    public ChatFrame(){
        createFrame();
    }

    public String getLogin(){
        String login = JOptionPane.showInputDialog(null, "Введите имя пользователя");
        if(login == null){
            int exitResult =  JOptionPane.showConfirmDialog(null, "Уже уходите?", "Окно выхода", JOptionPane.YES_NO_OPTION );
            if (exitResult == JOptionPane.YES_OPTION){
                return null;
            } else {
                return getLogin();
            }
        }
        //if there's an empty output and user pressed OK
        if(login.length() == 0){
            return getLogin();
        }
        return login;
    }

    private void createFrame(){
        frame = new JFrame("My chat");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                try{
                    TCPClient.closeChat();
                } catch (IOException ex) {
                    TCPClient.infoException(ex);
                }

            }

//            @Override
//            public void windowClosed(WindowEvent e) {
//                TCPClient.closeChat();
//            }
        });
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startedPanel = new StartedPanel();
        frame.add(startedPanel);
        frame.setVisible(true);
    }

//    public String getMessage(){
//        return null;
//    }

    public void showChat(MessagesStory story){
        chatPanel = new ChatPanel(story);//, socketWriter);
       // frame.setVisible(false);
        frame.setContentPane(chatPanel);
        frame.setVisible(true);
        //frame.add(chatPanel);
    }

    public void addMessage(Message newMessage){
        chatPanel.addMessage(newMessage);
    }
}
