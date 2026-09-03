import java.util.Arrays;
import java.util.Scanner;
public class day_28 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] sum = {11, 272, 3378, 464, 5455, 5666, 7567, 8447};
        Arrays.sort(sum);
        System.out.println(Arrays.toString(sum));
        int end = sum.length-1;
        int start = 0;
        while(start<=end){
        int m=(start+end)/2;
        if(sum[m]<n){
            start=m+1;
        }else if(sum[m]>n){
            end=m-1;
        }else{
            System.out.println("位置"+(m+1)+"值"+n);
            break;
        }
        }
    }
}

