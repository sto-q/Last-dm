package B;

import java.util.Arrays;

public class next4 {
    public int[] twosn(int[]sum,int a){
        for(int i=0;i<sum.length;i++){
            for(int j=i+1;j<sum.length;j++){
                if(sum[i]+sum[j]==a){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        next4 next4 = new next4();
        int[] sum = {1,2,3,4,5,6,7,8,9};
        int[] sums=next4.twosn(sum,9);
        System.out.println(Arrays.toString(sums));
    }
}
