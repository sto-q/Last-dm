import java.util.Scanner;

public class a1 {
    public static void main(String[]args){
        String a="abababababababababababa";
        int b=a.length();
        int index=0;
        String s="aba";
        int S=s.length();
        int max=b-S;
        for(int i=0;i<=max;i++){
            String s1=a.substring(i,i+S);
            if(s1.equals(s)){
                index++;
            }
        }
        System.out.println(index);
        Scanner sc=new Scanner(System.in);
        double x=sc.nextDouble();
        StringBuilder D=new StringBuilder();
        D.append(x);
        int i=D.indexOf(".");
        if(i>3){
            for(int m=i-3;m>0;m-=3){
                D.insert(m,".");
            }
        }
        System.out.println(D.toString());
    }
}
