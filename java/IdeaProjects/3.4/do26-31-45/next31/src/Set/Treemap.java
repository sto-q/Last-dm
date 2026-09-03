package Set;

import java.util.TreeMap;
import java.util.TreeSet;

public class Treemap {
    public static void main(String[] args) {
        TreeSet<Car> s=new TreeSet<>();
        s.add(new Car("BMW",1000));
        s.add(new Car("Audi",2000));
        s.add(new Car("Honda",3000));
        for(Car c:s){
            System.out.println(c);
        }
    }
}
