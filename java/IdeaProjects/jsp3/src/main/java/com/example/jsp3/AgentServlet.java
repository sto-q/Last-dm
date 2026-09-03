package com.example.jsp3;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Agent;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@WebServlet("/searchAgents")
//public class AgentServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String region=req.getParameter("region");
//        List<Agent> agents=new ArrayList<>();
//        Random r=new Random();
//        int count=r.nextInt(20);//随机返回20以内的数据
//        for(int i=0;i<count;i++){
//            Agent agent=new Agent();
//            agent.setAid(i+1);
//            agent.setAname("代理商"+i);
//            agent.setAno("ano"+i);
//            agent.setAregion(region);
//            agents.add(agent);
//        }
//        req.getSession().setAttribute("agents",agents);
//        resp.sendRedirect("data.jsp");//返回一个页面·。，这个页面会被前端load函数接收到
//    }
//}
@WebServlet("/searchAgents")
public class AgentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String region = req.getParameter("region");

        List<Agent> agents = new ArrayList<>();
        Random r = new Random();
        int count = r.nextInt(20);

        for (int i = 0; i < count; i++) {
            Agent agent = new Agent();
            agent.setAid(i + 1);
            agent.setAno("ano" + i);
            agent.setAname("代理商" + i);
            agent.setAregion(region);
            agents.add(agent);
        }

//        req.setAttribute("agents", agents);
//        req.getRequestDispatcher("data.jsp").forward(req, resp);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");//设置响应头信息，返回的数据类型是JSON类型的数据
        PrintWriter writer=resp.getWriter();
        writer.println(JSONObject.toJSON(agents));
        writer.flush();
        writer.close();
    }
}
