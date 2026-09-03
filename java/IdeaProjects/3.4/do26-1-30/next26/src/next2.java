public class next2 {
    public static void main(String[] args) {
        Util<?extends Number > c=new Util<>();
//        c.add(3);
//        c.add(2.2);
        Util<? super Number> c1=new Util<>();
        c1.add(123);
        c1.add(2.1);
    }
}
