import java.util.*;

public class ListArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>(100);
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add(2,"F");
        for(String s : list)
            System.out.println(s);
//        String old= list.set(0, "G");
//        System.out.println(old);
        System.out.println("______________________________");
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(2);
//        list1.remove((Integer)2);
//        for(Integer s : list1)
//            System.out.println(s);
//        System.out.println("________________________");
//        list1.remove(0);
//        for(Integer s : list1)
//            System.out.println(s);
//        System.out.println("________________________");
//
        int index1=list1.indexOf(2);
        int index2=list1.lastIndexOf(2);
        System.out.println(index1);
        System.out.println(index2);
        System.out.println("______________________________");
        Iterator<Integer> cc=list1.iterator();
        while(cc.hasNext()){
            System.out.println(cc.next());
        }
        System.out.println("______________________________");
        ListIterator<String> ccc=list.listIterator();
        while(ccc.hasNext()){
            System.out.println(ccc.next());
        }
        System.out.println("______________________________");
        ListIterator<String> cccc=list.listIterator(list.size());
        while(cccc.hasPrevious()){
            System.out.println(cccc.previous());
        }
        System.out.println("______________________________");
        List<String> subList=list.subList(1,4);
        System.out.println(subList);
        for(String s : subList)
            System.out.println(s);
    }
}
