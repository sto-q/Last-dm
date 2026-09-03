package datagram;

import java.io.IOException;
import java.net.*;

public class UdpClient {
    private static final int BUFFER_SIZE = 8192;
    private DatagramSocket client;
    private String ip;
    private int port;
    public UdpClient(String ip,int port) throws SocketException {
        this.ip = ip;
        this.port = port;
        client = new DatagramSocket();//绑定任意端口
    }
    public void sendPacket(String msg) throws IOException {
        DatagramUtil.sendPacket(client, msg, ip, port);
    }
    public String receivePacket(){
        DatagramPacket packet= DatagramUtil.receivePacket(client);
        int length = packet.getLength();
        return new String(packet.getData(), 0, length);
    }
    public static void main(String[] args) {
        try {
            UdpClient client=new UdpClient("localhost",6666);
            client.sendPacket("Helllo");
            System.out.println(client.receivePacket());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
