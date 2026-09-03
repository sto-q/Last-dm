public class text1 {
    public static void main(String[] args) {
        Util<String> c=new Util();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");
        c.add("e");
        c.add("f");
        Util<String> c1=new Util();
        c1.add("a");
        c1.add("b");
        c1.add("c");
        boolean contains1=c.containsAll(c1);
        System.out.println(contains1);
        Util<Integer> c2=new Util();
        c2.add(1);
        c2.add(2);
        c2.add(3);
        boolean contains2=c.containsAll(c2);
        System.out.println(contains2);
    }
}
