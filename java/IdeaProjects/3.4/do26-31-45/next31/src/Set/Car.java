package Set;

public class Car implements Comparable<Car> {
    private String brand;
    private double price;
    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public int compareTo(Car o) {
        return Double.compare(o.price, this.price);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
