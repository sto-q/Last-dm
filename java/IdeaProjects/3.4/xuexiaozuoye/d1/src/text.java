public class text {
    public static void main(String[] args) {
        Shape shape;
//        shape=new Shape();
        shape=new Circle(10);
        System.out.print("圆的面积于周长");
        System.out.printf("%.2f,%.2f\n",shape.area(),shape.perimeter());
        shape=new Rectangle(15.2,10.8);
        System.out.print("矩形的面积与周长");
        System.out.printf("%.2f,%.2f",shape.area(),shape.perimeter());
    }
}
