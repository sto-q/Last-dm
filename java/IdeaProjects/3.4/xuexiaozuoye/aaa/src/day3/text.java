package day3;

import java.util.Random;

public class text {
    public static void main(String[] args) {
        Point[] point=new Point[5];
        init(point);
        print(point);
        move(point);
        print(point);
    }
    public static void init(Point p[]) {
        Random r=new Random();
        for(int i=0;i<p.length;i++) {
            p[i]=new Point(r.nextInt(100),r.nextInt(100));
        }
    }
    public static void print(Point p) {
        System.out.print("("+p.x + ", " + p.y+")");
    }
    public static void move(Point[] p) {
        for(Point p1: p){
            p1.x+=11;
            p1.y+=11;
        }
    }
    public static void print(Point[] p) {
        for(Point p1: p){
          print(p1);
        }
        System.out.println();
    }
}
