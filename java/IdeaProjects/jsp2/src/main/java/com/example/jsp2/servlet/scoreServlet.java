package com.example.jsp2.servlet;

import com.example.jsp2.popj.Score;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/showScore")
public class scoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("aaa",new Score("lmq",90.1));
        List<Score> scores = new ArrayList<>();
        for(int i=0;i<20;i++){
            scores.add(new Score("小李"+i,70+i));
        }
        req.getSession().setAttribute("scores",scores);
        resp.sendRedirect("score.jsp");
    }
}
