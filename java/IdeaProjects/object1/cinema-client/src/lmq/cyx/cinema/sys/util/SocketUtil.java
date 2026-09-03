package lmq.cyx.cinema.sys.util;

import lmq.cyx.cinema.sys.message.Message;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 套接字工具类
 */
public class SocketUtil {
    private static  final String IP = "127.0.0.1";
    private static  final int PORT = 8888;

    /**
     *
     * @param msg 信息
     * @return
     * @param <T>发送类型不知道
     * @param <V>接收类型不知道
     */
    public static <T,V> V sendMessage(Message<T> msg){
        try{
            Socket client = new Socket(IP,PORT);//访问服务器
            //获取输流
            OutputStream os = client.getOutputStream();
            //将输出流包装为对象流
            ObjectOutputStream oos = new ObjectOutputStream(os);
            //对象流写对象==信息传输
            oos.writeObject(msg);
            oos.flush();
            //告诉客户端信息传递完毕
            client.shutdownOutput();
            InputStream is = client.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);//访问服务器读取内容
            V result= (V) ois.readObject();
            client.shutdownInput();//服务器信息传输完毕
            return result;//返回读取结果
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
