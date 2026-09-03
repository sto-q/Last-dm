package day1;

import java.util.Random;

public class next2 {
    public static void main(String[] args) {
        int[][]a = new int[3][4];
        int[][] b=new int[3][4];
        int[][] c=new int[3][4];
        getE(a);
        getE(b);
        compute(a,b,c,'+');
        show(a,b,c,'+');
        compute(a,b,c,'-');
        show(a,b,c,'-');
    }
    public static void getE(int a[][]){
        Random rand = new Random();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
             a[i][j]=rand.nextInt(100);
            }
        }
    }
    public static void compute(int a[][],int b[][],int c[][],char oper){
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[i].length;j++){
                c[i][j]=oper=='+'?a[i][j]+b[i][j]:a[i][j]-b[i][j];
            }
        }
    }
    public static void show(int a[][],int b[][],int c[][],char oper){
        int i;
        for(i=0;i<c.length;i++){
                for(int x:a[i]){
                    System.out.printf("%3d",x);
                }
                    System.out.printf("%3c",oper);
                    for(int x:b[i]){
                        System.out.printf("%3d",x);
                    }
                        System.out.printf("%3s","=");
                for(int x:c[i]){
                    System.out.printf("%4d",x);
                }
                    System.out.println();
                }
                    System.out.println();
                }
            }
