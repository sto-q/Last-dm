package day13;

import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入姓名和年龄");
            String name = sc.next();
            int age=sc.nextInt();
            if(age<=0)throw new MyException("年龄不能<=0");
            System.out.println("用户信息：");
            System.out.println("姓名"+name+"年龄"+age);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
class MyException extends Exception {
    String message;
    public MyException(String error) {
        message=error;
    }
    public String getMessage(){
        return message;
    }
}
