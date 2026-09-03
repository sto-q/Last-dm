import java.util.Scanner;

public class text2 {
    public static void main(String[] args) {
        int[] MM={0,1,2,3,4,};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int[] AA=new int[a];
        int[] BB=new int[b];
        for(int i=0;i<a;i++){
            AA[i]=MM[i%5];
        }
        for(int i=0;i<b;i++){
            BB[i]=MM[i%5];
        }
        int[] countA=new int[a];
        int[] countB=new int[b];
        for(int i=0;i<a;i++){
            countA[i]=sc.nextInt();
        }
        for(int i=0;i<b;i++){
            countB[i]=sc.nextInt();
        }
        int sumA=0;
        int sumB=0;
        for(int i=0;i<n;i++){

        }
        }
}
