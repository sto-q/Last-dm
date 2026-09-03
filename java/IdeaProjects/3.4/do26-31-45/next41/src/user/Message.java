package user;

import java.io.Serializable;

public class Message<T>implements Serializable {
    private T data;//数据
    private String action;//
    public Message(String action,T data) {
        this.data = data;
        this.action = action;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
}
