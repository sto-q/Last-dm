package com.example.jsp7.service.impl;

import com.example.jsp7.dao.impl.UserDao;
import com.example.jsp7.dao.impl.UserDaoImpl;
import com.example.jsp7.pojo.User;

public class UserServiceImpl implements UserService{
    private UserDao userDao=new UserDaoImpl();
    @Override
    public int login(String username, String password) {
        User user=userDao.getUserByUsername(username);
        if(user==null){
            return -1;
        }

        return password.equals(user.getPassword())?1:0;
    }

    @Override
    public boolean hasPermission(String username, String url) {
        return  userDao.getUrlCount(username,url)>0;
    }


}
