package Map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMaptext {
    public static void main(String[] args) {
        TreeMap<Computer,Integer>map = new TreeMap<>();
        map.put(new Computer("A",1000),1);
        map.put(new Computer("B",2000),2);
        map.put(new Computer("C",3000),3);
        for(Computer c:map.keySet()){
            System.out.println(c);
        }
        Comparator<Computer> c=( o1, o2)-> Double.compare(o1.getPrice(),o2.getPrice());
        TreeMap<Computer,Integer>map2 = new TreeMap<>(c);
        map2.put(new Computer("A",1000),1);
        map2.put(new Computer("B",2000),2);
        map2.put(new Computer("C",3000),3);
        for(Computer c2:map2.keySet()){
            System.out.println(c2);
        }
        }

    }
