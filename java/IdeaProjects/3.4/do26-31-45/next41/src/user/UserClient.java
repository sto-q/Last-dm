package user;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UserClient {
private Socket client;
public UserClient(String ip, int port) throws IOException {
    this.client = new Socket(ip,port);
}
public void sendMsg(Message<User> msg) throws IOException {
    MessageUtil.sendMsg(client, msg);
}
public String receiveMsg() throws IOException, ClassNotFoundException {
    Message<String> msg = MessageUtil.receiveMsg(client);
    return msg.getData();
}

    public static void main(String[] args) {
        try {
            UserClient client1=new UserClient("localhost",8888);
            client1.sendMsg(new Message<>("register",new User("admin","123456")));
            String backMsg=client1.receiveMsg();
            System.out.println(backMsg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
