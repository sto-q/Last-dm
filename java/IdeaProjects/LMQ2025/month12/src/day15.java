import java.util.Scanner;

public class day15 {
    public static void main(String[] args){
    int[] sum ={1,2,3,4,5,6,7,8,9};
    Scanner sc=new Scanner(System.in);
    int M=0;
    int n;
    n=sc.nextInt();
        int[] SSum=new int[n];
        for(int i=0;i<n;i++){
            M+=sum[i];
            SSum[i]=M;
        }
        for (int j=0;j<n;j++) {
            System.out.println(SSum[j]);
        }
    }
}
