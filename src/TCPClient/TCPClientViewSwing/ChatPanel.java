package TCPClient.TCPClientViewSwing;

import TCPServer.MessagesStory;

import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel {
    private static final Color backgroundColor = new Color(204, 255, 153);
    private static final int MESSAGE_FIELD_HEIGHT = ChatFrame.USER_FONT_SIZE*2;
    private static final int USERS_LIST_WIDTH = ChatFrame.USER_FONT_SIZE * 10;
    private static final int USERS_LIST_HEIGHT = ChatFrame.FRAME_HEIGHT - MESSAGE_FIELD_HEIGHT*2;
    private static final int MESSAGES_WINDOW_HEIGHT = USERS_LIST_HEIGHT;
    private static final int MESSAGES_WINDOW_WIDTH = ChatFrame.FRAME_WIDTH - USERS_LIST_WIDTH;


    public ChatPanel(MessagesStory story){
        super();
        this.setOpaque(true);
        this.setBackground(backgroundColor);
        this.setSize(ChatFrame.FRAME_WIDTH, ChatFrame.FRAME_HEIGHT);
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
    }
}
