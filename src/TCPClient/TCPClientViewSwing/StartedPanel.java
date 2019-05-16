package TCPClient.TCPClientViewSwing;

import javax.swing.*;
import java.awt.*;

public class StartedPanel extends JPanel {
    private static final Color backgroundColor = new Color(204, 255, 153);
    private final int LINE_HEIGHT = ChatFrame.FRAME_HEIGHT/5;
    private final int LINE_INDENT = ChatFrame.INFO_FONT_SIZE*5;

    public StartedPanel(){
        super();
        this.setOpaque(true);
        this.setBackground(backgroundColor);
        this.setSize(ChatFrame.FRAME_WIDTH, ChatFrame.FRAME_HEIGHT);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(ChatFrame.infoFont);
        g.drawString("Welcome to the chat!", LINE_INDENT, LINE_HEIGHT);
        g.drawString("Please, enter your nickname", LINE_INDENT, LINE_HEIGHT*2);
    }
}
