public class Car {
    private Engine engine;
    private String brand;
    private double price;
    public Car(String brand, double price) {
        this.engine = new Engine("sb",250);
        this.brand = brand;
        this.price = price+ engine.price;
    }
    public Car(Engine engine,double price, String brand) {
        this.price = price+ engine.price;
        this.brand = brand;
        this.engine=engine;
    }
    public void show(){
        this.engine.show();
    }

    class Engine{
        private String brand;
        private double price;
        public Engine(String brand, double price) {
            this.brand = brand;
            this.price = price;
        }
        public void show(){
            System.out.println("汽车"+Car.this.brand+"  发动机:"+brand+"    price="+ price);
            System.out.println("Allprice="+Car.this.price);
        }
    }
}
