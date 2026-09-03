package com.example.jsp3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        int flog=0;
        if("admin".equals(username)&& "123456".equals(password)){
            flog=1;
        }
        PrintWriter writer=resp.getWriter();
        writer.print(flog);
        writer.flush();
        writer.close();
    }
}
