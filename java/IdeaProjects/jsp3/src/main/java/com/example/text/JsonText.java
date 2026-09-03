package com.example.text;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Agent;
import netscape.javascript.JSObject;

public class JsonText {
    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.setAid(+1);
        agent.setAno("ano");
        agent.setAname("代理商");
        agent.setAregion("成都");
        System.out.println(agent.toJson());
        //将一个对象转换为JSon格式的字符串
        System.out.println(JSONObject.toJSON(agent));
    }
}
