package day5;

public class text {
    public static void main(String[] args) {
        int x1=10,y1=11;
        int x2=20,y2=15;
        Line line = new Line(x1,y1,x2,y2);
        System.out.print("直线位置：");
        line.print();
        System.out.println("直线长度：");
        System.out.printf("%.2f\n",line.length());
        line.move(15,17);
        System.out.print("移动后位置");
        System.out.println(line.toString());
        System.out.println("---------------------");
        circle C=new circle(-10,-20,10);
        System.out.print("半径与位置：");
        C.print();
        System.out.print("面积与周长：");
        System.out.printf("%.2f,%.2f\n",C.area(),C.perim());
        C.move(5,6);
        System.out.print("移动后半径与位置：");
        System.out.println(C.toString());
    }
}
