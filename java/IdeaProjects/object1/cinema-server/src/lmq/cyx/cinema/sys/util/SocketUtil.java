package lmq.cyx.cinema.sys.util;

import lmq.cyx.cinema.sys.message.Message;

import java.io.*;
import java.net.Socket;

/**
 * 套接字工具类
 */
public class SocketUtil {
    /**
     *
     * @param client 客户端发送的信息
     * @return
     * @param <T>不知道发送类型
     */
    public static<T>Message<T> receiveMsg(Socket client){
        try{
            InputStream is=client.getInputStream();//获取读取数据的通道，字节流底层通道就是client
            ObjectInputStream ois=new ObjectInputStream(is);//将字节流转换为对象流
            Message<T> msg= (Message<T>) ois.readObject();//泛型对象msg被赋值对象
            client.shutdownInput();//client不在接收数据
            return msg;//返回对象
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 向客户端返回处理结果
     * @param client 客户端套接字
     * @param data 处理结果
     * @param <V> 不知道类型
     */
    public static<V> void sendBack(Socket client,V data){
        try{
            OutputStream os=client.getOutputStream();//获取输出数据的通道
            ObjectOutputStream oos=new ObjectOutputStream(os);//转换为对象流
            oos.writeObject(data);//将泛型数据写入底层通道client中
            oos.flush();//通道关闭
            client.shutdownOutput();//禁用输出通道
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
