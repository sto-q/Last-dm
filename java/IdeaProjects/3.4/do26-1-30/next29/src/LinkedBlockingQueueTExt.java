import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTExt {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("four");
        queue.add("five");
        queue.offer("six");
        queue.remove();
        for (String s : queue) {
            System.out.println(s);
        }
    }
}
