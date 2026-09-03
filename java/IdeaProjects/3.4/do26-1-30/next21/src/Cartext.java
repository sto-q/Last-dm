public class Cartext {
    public static void main(String[] args) {
        Car a=new Car("sss",10000);
        a.show();
        Car.Engine b=new Car("ccc",8000).new Engine("sdsd",200);
        b.show();
        Car c=new Car(b,222222,"siudf");
        c.show();
        Car.Engine d= a.new Engine("asd",236745);
        d.show();
        Car e=new Car(d,222222,"siudf");
        e.show();

    }
}
