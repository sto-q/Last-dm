import java.util.Iterator;

public class text {
    public static void main(String[] args) {
        Util<Integer> O=new Util<>();
        O.add(1);
        O.add(2);
        O.add(3);
        O.add(4);
        O.add(5);
        System.out.println(O.size());
        O.delete(2);
//        for(int i=0;i<O.size();i++){
//            Object o=O.get(i);
//            System.out.println(o);
//        }
        for(Iterator<Integer> i=O.iterator();i.hasNext();){
            Object o=i.next();
            System.out.println(o);
        }
    }
}
