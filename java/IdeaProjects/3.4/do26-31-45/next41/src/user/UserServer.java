package user;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserServer {
    private static final String USER_PATH = "C:\\Users\\seto\\IdeaProjects\\3.4\\do26-31-45\\next41\\src\\user\\user.obj";
    private ServerSocket server;
    public UserServer(int port) throws IOException {
        this.server = new ServerSocket(port);
    }
    public void start() {
        while (true) {
            try {
                Socket userCline = server.accept();
                Message<User> message=MessageUtil.receiveMsg(userCline);
                String action=message.getAction();
                if("register".equals(action)) {
                    register(userCline, message);
                }else if("login".equals(action)) {
                    login(userCline, message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void login(Socket userCline, Message<User> message) throws IOException {
        List<User> users=FileUtil.readdata(USER_PATH);
        User loginUser=message.getData();
        boolean exists= users.stream().anyMatch(u->u.getUsername().equals(loginUser.getUsername()));
        String  msg=exists?"登录成功":"登陆失败";
        Message<String> backMsg=new Message<>("back",msg);
        MessageUtil.sendMsg(userCline,backMsg);
    }
    private void register(Socket userCline,Message<User> message) throws IOException {
        List<User> users=FileUtil.readdata(USER_PATH);
        User registerUser=message.getData();
//        boolean exists= users.stream().anyMatch(u->u.getUsername().equals(registerUser.getUsername()));
        boolean exists = users.stream().anyMatch(new Predicate<User>(){

            @Override
            public boolean test(User user) {
                return user.getUsername().equals(registerUser.getUsername());
            }
        });
        Message<String> backMsg=new Message<>("back",null);
        if(exists) {
            backMsg.setData("账号已经注册");
        }else {
            users.add(registerUser);
            boolean result= FileUtil.writedata(USER_PATH,users);
            String info=result?"注册成功":"注册失败";
            backMsg.setData(info);
        }
            MessageUtil.sendMsg(userCline,backMsg);
    }
    public static void main(String[] args) {
        try {
            UserServer server=new UserServer(8888);
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
