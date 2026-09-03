package day2;

public class Point {
    int x;
    int y;
     Point(int x, int y) {
        this.x = x;
        this.y = y;
//        System.out.println("访问方法当前对象地址"+this);
    }
//    int getX(){
//         return x;
//    }
//    int getY(){
//         return y;
//    }
//    void move(int dx, int dy) {
//         x += dx;
//         y += dy;
//    }
//    public void show(){
//         System.out.println("坐标"+x+","+y);
//        System.out.println("当前方法对象地址"+this);
//    }
   public void show(){
         System.out.println("("+x+","+y+")");
    }
}
