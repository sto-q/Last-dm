import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack <T>extends ArrayList<T> {
    public void push(T t) {
        add(t);
    }
    public T pop(){
        if(size()==0)throw new IllegalArgumentException("Stack is empty");
        return remove(size()-1);
//      T t= get(size()-1);
//      remove(t);
//      return t;
    }
}
