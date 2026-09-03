import java.util.Scanner;

public class text3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m;
        int amx=0;
        for (int i = 0; i < n; i++) {
            amx=i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[amx]) {
                    amx=j;
                }
            }
            m=arr[i];
            arr[i]=arr[amx];
            arr[amx]=m;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
