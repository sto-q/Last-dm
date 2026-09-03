package Map;

import java.util.Map;

public class text {
    public static void main(String[] args) {
        MyMap<Integer,String> m = new MyMap<>();
        m.put(1, "one");
        m.put(2, "two");
        m.put(3, "three");
        m.put(4, "four");
        m.put(5, "five");
        m.put(17, "six");
        m.put(33, "seven");
        System.out.println(m.get(17));
        System.out.println(m.get(33));
        System.out.println(m.get(4));
        System.out.println(m.get(5));
        System.out.println(m.get(2));
        System.out.println(m.get(3));
    }
}
