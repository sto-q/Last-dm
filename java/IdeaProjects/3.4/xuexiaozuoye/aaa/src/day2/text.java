package day2;

public class text {
    public static void main(String[] args) {
        Point p=new Point(10,20);
//        p.move(11,22);
        System.out.println("main中p地址"+p);
        p.show();
        System.out.println("------------------------------------");
         p=new Point(-10,-20);
//        p.move(-11,-22);
        System.out.println("main中p地址"+p);
        p.show();
    }
}
