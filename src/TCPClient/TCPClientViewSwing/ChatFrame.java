package TCPClient.TCPClientViewSwing;

import javax.swing.*;
import java.awt.*;

public class ChatFrame {
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 500;
    private static final Color backgroundColor = new Color(204, 255, 153);
    private JFrame frame;

    public ChatFrame(){
        createFrame();
    }

    private void createFrame(){
        frame = new JFrame("My chat");
        frame.setBackground(backgroundColor);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
