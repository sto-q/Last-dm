import java.util.Scanner;

public class text4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=n/2; i>=1; i--) {
            Doud(arr,i,n);
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void Doud(int[]a,int i,int n) {
        int now=i;//当前节点
        int mon;//最大孩子
        while(now*2<=n) {
            mon=now*2;
            if (now*2+1<=n&&a[now*2]<a[now*2+1])//当右孩子大于左孩子
                 {
                mon=now*2+1;
            }
            if(a[mon]>a[now]) {
                int temp=a[mon];
                a[mon]=a[now];
                a[now]=temp;
                now=mon;
            }
            else {
                break;
            }
        }
    }
}
