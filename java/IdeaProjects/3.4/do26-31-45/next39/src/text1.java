import java.util.Scanner;

public class text1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] A = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        int a,b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(Mm(A, a, b));

    }
    public static int Mm(int[][] MM,int x,int y){
        int n = MM.length;
        int m = MM[0].length;
        for(int i=n-1;i>=0;i--){
            int a=MM[i][0];
            int b=MM[i][1];
            int c=MM[i][2];
            int d=MM[i][3];
            if((x>a&&y>b)&&(x<a+c&&y<b+d)){
                return i+1;
            }
        }
        return -1;
    }
}
