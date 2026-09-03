package com.example.jsp2.servlet;

import com.example.jsp2.popj.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

@WebServlet("/showData")
public class ManageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user",new User("李四","男"));
        HttpSession session=req.getSession();
        session.setAttribute("user",new User("张三","女"));


        Map<String, Object>data=new HashMap<>();
        data.put("admin",90);
        data.put("text",80);
        session.setAttribute("data",data);
        List<User> users= Arrays.asList(new User("王五","男"),new User("小米","其他"));
        session.setAttribute("users",users);
        req.getRequestDispatcher("manage.jsp").forward(req,resp);
//        resp.sendRedirect("manage.jsp");
    }
}
