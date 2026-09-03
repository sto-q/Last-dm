package day10;

public class Vehicle extends Transport {
    public Vehicle(String name, int speed) {
        super(name,speed);
    }
    public void run(){
        System.out.println(name+"汽车以"+speed+" km/h的速度行驶");
    }
}
