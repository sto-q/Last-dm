
import java.util.Scanner;

class text {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] sum= new int[n];
    for(int i=0; i<n; i++){
        sum[i]=sc.nextInt();
    }
    int s=sc.nextInt();
    int[] psum= new int [sum.length+1];
    for(int i=0; i<sum.length; i++){
        psum[i+1]=psum[i]+sum[i];
    }
    int[] count=new int[s];
    for(int i=0;i<s;i++){
        int l=sc.nextInt();
        int r=sc.nextInt();
        count[i]=psum[r]-psum[l-1];
    }
    for(int i=0; i<s; i++){
        System.out.print(count[i]+" ");
    }
}
}

