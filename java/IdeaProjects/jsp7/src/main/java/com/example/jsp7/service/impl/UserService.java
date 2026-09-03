package com.example.jsp7.service.impl;

public interface UserService {
    int login(String username,String password);
    boolean hasPermission(String username,String url);
}
