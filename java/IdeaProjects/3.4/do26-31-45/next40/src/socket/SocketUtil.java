package socket;

import java.io.*;
import java.net.Socket;

public class SocketUtil {
    public static String receiveMsg(Socket socket) throws IOException {
        InputStream in=socket.getInputStream();
        InputStreamReader isr=new InputStreamReader(in);
        BufferedReader br=new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String line;
        while((line=br.readLine())!=null){
            sb.append(line);
        }
        socket.shutdownInput();
        return sb.toString();
    }
    public static void sendMsg(Socket socket,String msg) throws IOException {
    OutputStream os = socket.getOutputStream();
    OutputStreamWriter osw = new OutputStreamWriter(os);
        osw.write(msg);
        osw.flush();
        socket.shutdownOutput();
    }
}
