package day10;

public class Car extends Vehicle {

    public Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void run() {
        System.out.println(name+"轿车"+speed+"km/h的速度行驶");
    }
}
