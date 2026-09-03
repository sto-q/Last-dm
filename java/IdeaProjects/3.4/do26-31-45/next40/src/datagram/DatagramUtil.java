package datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DatagramUtil {
    private static final int BUFFER_SIZE = 8192;
    public static void sendPacket(DatagramSocket socket,String msg,String ip,int port) throws IOException {
        byte[] buf = msg.getBytes();
        //创建发生数据的数据包
        InetAddress address = InetAddress.getByName(ip);
        DatagramPacket packet=new DatagramPacket(buf,0, buf.length,address,port);
        socket.send(packet);
    }
    public static DatagramPacket receivePacket(DatagramSocket socket) {
        byte[] buf = new byte[BUFFER_SIZE];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        try {
            socket.receive(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return packet;
    }
}
