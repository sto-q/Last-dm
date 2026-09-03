package day10;

public class Ship extends Transport{
    public Ship(String name, int speed) {
        super(name,speed);
    }
    public void run(){
        System.out.println(name+"航船以"+speed+" km/h的速度航行");
    }
}
