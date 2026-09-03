package day9;

public class text {
    public static void main(String[] args) {
        Circle circle=new Circle(10);
        Rectangle rectangle=new Rectangle(15.2,10.8);
        System.out.print("园的面积和周长：");
        System.out.printf("%.2f,%.2f\n",circle.area(),circle.perimeter());
        System.out.print("矩形的面积与周长：");
        System.out.printf("%.2f,%.2f\n",rectangle.area(),rectangle.perimeter());
    }
}
