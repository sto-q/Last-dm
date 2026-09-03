import java.util.LinkedList;

public class Denode<T> {
    private T data;
    public Denode<T> next;
    public Denode<T> prev;

    public Denode(T data, Denode<T> next, Denode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Denode<T> getNext() {
        return next;
    }

    public void setNext(Denode<T> next) {
        this.next = next;
    }

    public Denode<T> getPrev() {
        return prev;
    }

    public void setPrev(Denode<T> prev) {
        this.prev = prev;
    }
}
