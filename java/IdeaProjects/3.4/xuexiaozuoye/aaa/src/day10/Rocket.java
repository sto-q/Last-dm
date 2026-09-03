package day10;

public class Rocket extends Transport {
    public Rocket(String name, int speed) {
        super(name,speed);
    }
    public void run(){
        System.out.println(name+"火箭以"+speed+" km/h的速度穿行");
    }
}
