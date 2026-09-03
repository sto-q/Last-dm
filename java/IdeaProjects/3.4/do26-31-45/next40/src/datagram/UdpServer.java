package datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    private static final int BUFFER_SIZE = 8192;
    private DatagramSocket server;
    public UdpServer(int port) throws SocketException {
        server = new DatagramSocket(port);
    }
    public void star(){
        while(true){
            DatagramPacket packet=DatagramUtil.receivePacket(server);
            int length = packet.getLength();
            String message = new String(packet.getData(), 0, length);
            System.out.println(message);
            String ip = packet.getAddress().getHostAddress();
            int port = packet.getPort();
            try {
                DatagramUtil.sendPacket(server,"holle,l'm server",ip,port);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        try{
            UdpServer server=new UdpServer(6666);
            server.star();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}
