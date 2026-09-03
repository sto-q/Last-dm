package com.example.jsp7.dao.impl;

import com.example.jsp7.pojo.User;

public interface UserDao {
    User getUserByUsername(String username);
    Integer getUrlCount(String username,String url);
}
