import java.util.Stack;

public class MyStacktext {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        while(!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }
    }
}
