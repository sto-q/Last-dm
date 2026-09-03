package day1;

import java.util.Random;

public class next1 {
    public static void main(String[] args) {
        int[] a = new int[10];
        getE(a);
        show(a);
        sort(a);
        show(a);
    }
    public static void getE(int a[]){
        Random rand = new Random();
        for(int i=0;i<a.length;i++){
            a[i]=rand.nextInt(100);
        }
    }
    public static void show(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }
    public static void sort(int[] a){
        int i,j,t;
        for(i=0;i<a.length-1;i++){
            for(j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
    }
}
