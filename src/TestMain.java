import TCPClient.TCPClientViewSwing.ChatFrame;

public class TestMain {
    public static void main(String[] args){
        ChatFrame frame = new ChatFrame();
        String login = frame.getLogin();
        if (login == null){
            System.out.println("null");
        } else {
            System.out.println(login + login.length());
        }
    }
}
