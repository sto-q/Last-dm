package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    private ServerSocket server;
    public TcpServer(int port) throws IOException {
        this.server = new ServerSocket(port);
    }
    public void star(){
        //服务器不能挂
        while(true){
            try {
                //等待连接，程序被堵塞，与Scaaner的next一样;
                Socket connectionCline=server.accept();
                String msg=SocketUtil.receiveMsg(connectionCline);
                System.out.println(msg);
                SocketUtil.sendMsg(connectionCline,"hello,Client");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {
        try{
            TcpServer server=new TcpServer(6666);
            server.star();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
