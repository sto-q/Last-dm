package user;

import java.io.*;
import java.net.Socket;

public class MessageUtil {
    public static<T> void sendMsg(Socket socket, Message<T> msg) throws IOException {
        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(msg);
        oos.flush();
        socket.shutdownOutput();
    }
    public static <T> Message<T> receiveMsg(Socket socket) throws IOException, ClassNotFoundException {
        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        Message<T> message=(Message<T>) ois.readObject();
        return message;
    }
}
