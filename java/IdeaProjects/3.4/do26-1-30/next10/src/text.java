import java.util.Scanner;
public class text {
    public static void main(String[] args) {
        double a,b,c,d;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入三个边：");
        a = sc.nextDouble();
        b=sc.nextDouble();
        c=sc.nextDouble();
        if(a+b>c||a+c>b||b+c>a){
            d=(a+b+c)/2;
            System.out.printf("%.1f\n",Math.sqrt(d*(d-a)*(d-b)*(d-c)));
            System.out.println(a+b+c);
        }else System.out.println("无法构成三角形");
    }
}
