public class Mynide<T> {
    private T data;
    public Mynide<T> next;

    public Mynide(T data, Mynide<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Mynide<T> getNext() {
        return next;
    }

    public void setNext(Mynide<T> next) {
        this.next = next;
    }
}
