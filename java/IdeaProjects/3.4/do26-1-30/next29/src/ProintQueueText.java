import java.util.PriorityQueue;

public class ProintQueueText {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        PriorityQueue<User> queue1 = new PriorityQueue<>();
        queue1.offer(new User("a",1));
        queue1.offer(new User("b",2));
        queue1.offer(new User("c",3));
        queue1.offer(new User("d",4));
        while (!queue1.isEmpty()) {
            System.out.println(queue1.poll());
        }
    }
}
