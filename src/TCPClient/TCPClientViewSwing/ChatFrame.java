package TCPClient.TCPClientViewSwing;

import javax.swing.*;
import java.awt.*;

public class ChatFrame {
    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 500;
    public static final int INFO_FONT_SIZE = FRAME_HEIGHT /20;
    public static final Font infoFont = new Font("TimesRoman", Font.BOLD, INFO_FONT_SIZE);
    private JFrame frame;
    private StartedPanel startedPanel;

    public ChatFrame(){
        createFrame();
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
