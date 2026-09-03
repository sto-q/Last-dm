import java.util.InputMismatchException;
import java.util.Scanner;
public class Example1 {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[]args){
        int c=text();
    }
/**
 * public static void text(){
 * int a=sc.nextInt();
 * int b=sc.nextInt();
 * if(b==0){
 * throw new ArithmeticException("除法中分母不能为0");
 * }
 * System.out.println(a/b);
 * }
 */
public static int text()throws InputMismatchException ,ArithmeticException{
        int a=sc.nextInt();
        int b=sc.nextInt();
        return a/b;
    }
}
