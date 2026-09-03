import java.util.Scanner;

public class text2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] arr2 = new int[n + 1][m + 1];
        for (int x = 1; x < n; x++) {
            for (int y = 1; y < m; y++) {
                arr2[x][y] = arr2[x - 1][y] + arr2[x][y - 1] - arr2[x - 1][y - 1] + arr[x - 1][y - 1];
            }
        }
        if (arr2[n][m] == n * m) {
            System.out.println(n);
        } else if (arr2[n][m] > n * m) {

        }
    }
}