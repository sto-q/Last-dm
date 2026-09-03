package day10;

public class text {
    public static void main(String[] args) {
        Transport a;
        a= new Rocket("长征4号",2200);
        a.run();
        a=new Car("红旗",120);
        a.run();
        a=new Plane("空客A320",800);
        a.run();
        a=new Ship("辽宁舰",23);
        a.run();
        a=new Truck("东风",80);
        a.run();
        a=new Vehicle("金龙",70);
        a.run();
    }
}
