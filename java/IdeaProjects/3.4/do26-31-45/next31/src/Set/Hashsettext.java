package Set;

import java.util.HashSet;

public class Hashsettext {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        HashSet<String> set2 = new HashSet<>();
        set2.add("a");
        set2.add("b");
        set2.add("c");
        set.addAll(set2);
//        System.out.println(set);
        for (String s : set) {
            System.out.println(s);
        }
    }
}
