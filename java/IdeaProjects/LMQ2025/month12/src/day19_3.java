import java.util.Scanner;
public class day19_3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=n/2+1;
        for(int i=1;i<=m;i++){
            for(int k=m-i;k>0;k--){
                System.out.print(" ");
            }
            for(int j=0;j<i*2-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        int k=n-m;
        for(int i=k;i>=0;i--){
            for(int j=k-i+1;j>0;j--){
                System.out.print(" ");
            }
            for(int g=0;g<2*i+1;g++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
