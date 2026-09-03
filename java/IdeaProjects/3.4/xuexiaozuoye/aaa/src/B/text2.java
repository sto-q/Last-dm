package B;

import java.util.Scanner;

public class text2 {
    public static void main(String[] args) {
        boolean a = true;
        int b=0;
        Scanner sc = new Scanner(System.in);
        int c=sc.nextInt();
        int d=sc.nextInt();
        if(c>d){
            int temp=c;
            c=d;
            d=temp;
        }
        for(int i=c;i<=d;i++){
            a=true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    a=false;
                    break;
                }
            }
            if(a){
                b++;
                if (b % 5 == 0) {
                    System.out.println(i);
                } else {
                    System.out.print(i + "\t");
                }
            }
        }

    }
}
