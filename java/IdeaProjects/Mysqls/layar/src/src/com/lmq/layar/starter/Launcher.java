package src.com.lmq.layar.starter;

import src.com.lmq.layar.controller.UserController;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        UserController controller = new UserController();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号");
        String name = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        String result=controller.register(name, password);
        System.out.println("<UNK>");
    }
}
