import java.util.Arrays;
import java.util.Scanner;
public class day_26 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[] HH=new char[n];
        for(int i=0;i<n;i++){
            HH[i]=sc.next().charAt(0);
        }
        char[] JJ= Arrays.copyOf(HH,HH.length+1);
        int inx=2;
        System.arraycopy(HH,0,JJ,0,inx);
        JJ[inx]='M';
        System.arraycopy(HH,inx,JJ,inx+1,HH.length-inx);
        System.out.print(JJ);
    }
}
