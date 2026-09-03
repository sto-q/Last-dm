import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a>b){
            int max=a;
            a=b;
            b=max;
        }
        if(a>c){
            int max=a;
            a=c;
            c=max;
        }
        if(b>c){
            int max=b;
            b=c;
            c=max;
        }
        System.out.println(a+" "+b+" "+c);
    }
}
