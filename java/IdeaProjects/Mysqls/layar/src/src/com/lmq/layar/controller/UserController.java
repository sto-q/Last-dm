package src.com.lmq.layar.controller;


import src.com.lmq.layar.service.Userservice;
import src.com.lmq.layar.service.impl.UserServiceimpl;

public class UserController {
    private Userservice userservice=new UserServiceimpl();
    public String register(String username, String password) {
        return userservice.register(username, password);
    }
    private String login(String username,String passoword){
        return userservice.login(username, passoword);
    }
}
