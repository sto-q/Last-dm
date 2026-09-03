package day10;

public class Truck extends Vehicle {
    public Truck(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void run() {
        System.out.println(name+"卡车以"+speed+"km/h在公路上行驶");
    }
}
