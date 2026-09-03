import java.util.LinkedList;

public class Linklist {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.addLast("D");
        list.removeFirst();
        list.removeLast();
        list.addFirst("E");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
