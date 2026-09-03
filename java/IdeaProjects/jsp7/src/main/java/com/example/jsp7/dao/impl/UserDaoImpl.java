package com.example.jsp7.dao.impl;

import com.example.jsp7.Jdbc.JdbcUtil;
import com.example.jsp7.handler.SingleResultHandler;
import com.example.jsp7.pojo.User;

public class UserDaoImpl implements UserDao{
    @Override
    public User getUserByUsername(String username) {
        String sql="SELECT username,password,name FROM user WHERE username=?";
        return (User) JdbcUtil.query(sql,new SingleResultHandler<>(User.class),username);

    }

    @Override
    public Integer getUrlCount(String username, String url) {
        String sql="SELECT COUNT(*) FROM user_role a INNER JOIN role b ON a.role_id=b.id INNER JOIN role_permission c ON b.id=c.role_id INNER JOIN permission d ON c.permission_id=d.id WHERE a.username=? AND d.url=?";
        return (Integer) JdbcUtil.query(sql,new SingleResultHandler<>(Integer.class),username,url);
    }
}
