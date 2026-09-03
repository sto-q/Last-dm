package day12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        int a,b;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入两个整数");
        try{
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a/b);
        }catch(ArithmeticException e){
            System.out.println("数字异常，除数不能为0");
        }catch(InputMismatchException e){
            System.out.println("输入类型不匹配，必须输入整数");
        }finally{
            System.out.println("程序正常运行结束");
        }
    }
}
