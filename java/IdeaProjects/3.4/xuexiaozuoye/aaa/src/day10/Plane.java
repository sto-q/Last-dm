package day10;

public class Plane extends Transport {
    public Plane(String name, int speed) {
        super(name,speed);
    }
    public void run(){
        System.out.println(name+"飞机以"+speed+" km/h的速度飞行");
    }
}
