package lmq.cyx.cinema.sys.starter;

import lmq.cyx.cinema.sys.message.Message;
import lmq.cyx.cinema.sys.tack.MessagrProcessTack;
import lmq.cyx.cinema.sys.util.SocketUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 影院服务器
 */
public class CiinemaServer {
    private ServerSocket serverSocket;
    public CiinemaServer(int port) throws IOException {
        this.serverSocket =new ServerSocket(port);
    }
    public void start() {
        while (true) {
            try {//等待客户端连接
                Socket client = serverSocket.accept();//就是堵塞通道直到有人访问客户端，并创建client通信通道
                new Thread(new MessagrProcessTack(client)).start();//创建一个线程，MessagrProcessTack继承了Runnable接口，并驱动线程
                //信息处理
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try{
            CiinemaServer server=new CiinemaServer(8888);//创建服务器端，给定访问服务器端的接口为8888
            server.start();//启动服务器端，并运行MessagrProcessTack中被重写的run方法
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
