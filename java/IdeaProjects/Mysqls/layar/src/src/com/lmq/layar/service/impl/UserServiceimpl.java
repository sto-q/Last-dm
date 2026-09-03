package src.com.lmq.layar.service.impl;


import src.com.lmq.layar.dao.UserDao;
import src.com.lmq.layar.dao.impl.UserDaoimpl;
import src.com.lmq.layar.mondel.User;
import src.com.lmq.layar.service.Userservice;
import src.com.lmq.layar.util.MD5;

public class UserServiceimpl implements Userservice {
private UserDao userDao=new UserDaoimpl();
    @Override
    public String register(String username, String password) {
      String salt= MD5.RoundStr(30);
      String encrypt=MD5.encrypt(username, salt);
      int affectedRows=userDao.saveUser(username, encrypt, salt);
      return affectedRows==1?"YES":"NO";
    }

    @Override
    public String login(String username, String password) {
        User user= userDao.getUserByUsername(username);
        if(user==null)   return "NO";
        String salt=user.getStal();
        String encrypt=MD5.encrypt(username, salt);
        return encrypt.equals(user.getPassword())?"YES":"NO";
    }
}
