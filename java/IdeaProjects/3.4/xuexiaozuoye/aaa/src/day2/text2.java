package day2;

public class text2 {
    public static void main(String[] args) {
        Point p=new Point(10,20);
        System.out.println("main中p地址"+p);
        System.out.print("move前坐标");
        p.show();
        move(p);
        System.out.print("move后坐标");
        p.show();
    }
    public static void move(Point p){
        System.out.println("在move()方法表示对象的地址"+p);
        p.x=p.x+11;
        p.y=p.y+22;
        System.out.print("在move()方法的坐标");
        System.out.println("("+p.x+","+p.y+")");
    }
}
