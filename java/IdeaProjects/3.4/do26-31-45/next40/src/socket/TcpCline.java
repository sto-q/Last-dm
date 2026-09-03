package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TcpCline {
    private Socket cline;

    public TcpCline(String ip, int port) throws IOException {
        cline = new Socket(ip,port);
    }
    public void sendMsg(String msg) throws IOException {
        SocketUtil.sendMsg(cline,msg );
    }
    public String receiveMsg()throws IOException{
        return SocketUtil.receiveMsg(cline);
    }

    public static void main(String[] args) {
        try {
            TcpCline cline=new TcpCline("localhost",6666);
            cline.sendMsg("hello");
            System.out.println(cline.receiveMsg());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
