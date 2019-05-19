package TCPClient.TCPClientViewSwing;

import javax.swing.*;
import java.awt.*;

public class StartedPanel extends JPanel {
    private static final Color backgroundColor = new Color(204, 255, 153);
    private final int LINE_HEIGHT = ChatFrame.FRAME_HEIGHT/5;
    private final int LINE_INDENT = ChatFrame.INFO_FONT_SIZE*5;
    private final int LOGIN_COLUMNS = 20;
    private JTextField loginField = new JTextField(LOGIN_COLUMNS);

    public StartedPanel(){
        super();
        this.setOpaque(true);
        this.setBackground(backgroundColor);
        this.setSize(ChatFrame.FRAME_WIDTH, ChatFrame.FRAME_HEIGHT);
        this.setLayout(null);
        //setLoginField();
    }

//    private void setLoginField(){
//        loginField.setFont(ChatFrame.infoFont);
//        loginField.setBounds(LINE_INDENT, LINE_HEIGHT*3, LOGIN_COLUMNS*ChatFrame.infoFont.getSize()/2,
//                ChatFrame.infoFont.getSize()*2);
//        this.add(loginField);
//    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(ChatFrame.infoFont);
        g.drawString("Welcome to the chat!", LINE_INDENT, LINE_HEIGHT);
       // g.drawString("Please, enter your nickname", LINE_INDENT, LINE_HEIGHT*2);
    }
}
