package TCPClient.TCPClientViewSwing;

import javax.swing.*;
import java.awt.*;

public class ChatFrame {
    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 500;
    public static final int INFO_FONT_SIZE = FRAME_HEIGHT /20;
    public static final int USER_FONT_SIZE = FRAME_HEIGHT / 35;
    public static final Font infoFont = new Font("TimesRoman", Font.BOLD, INFO_FONT_SIZE);
    public static final Font userFont = new Font("Monospaced",Font.BOLD, USER_FONT_SIZE);

    private JFrame frame;
    private StartedPanel startedPanel;

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startedPanel = new StartedPanel();
        frame.add(startedPanel);
        frame.setVisible(true);
    }
}
