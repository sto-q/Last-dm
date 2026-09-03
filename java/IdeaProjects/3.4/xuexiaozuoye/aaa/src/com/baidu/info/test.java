package com.baidu.info;

import static java.lang.System.*;
import static java.lang.Math.PI;
import static java.util.Arrays.sort;
import java.util.Scanner;
import static classeslib.MyArray.*;
import static classeslib.MyMath.*;
public class test{
    public static void main(String args[]) {
        int a[]= {28, 37, 47, 83, 42, 98, 78, 23, 4, 82};
        int x;
        double radius;
        Scanner reader=new Scanner(in);
        out.println("数组元素：");
        print(a);
        sort(a);
        out.println("数组元素排序后：");
        print(a);
        out.print("输入一个圆的半径：");
        radius=reader.nextDouble();
        out.printf("半径为%.1f的圆的面积%.2f\n",
                radius,PI*radius*radius);
        out. print(" 输入一个自然数：");
        x=reader.nextInt();
        if(isPrime(x))
            out.print(x+" 是一个素数");
        else
            out.print(x+"不是一个素数");}
}