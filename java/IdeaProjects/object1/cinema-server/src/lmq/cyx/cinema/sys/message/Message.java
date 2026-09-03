package lmq.cyx.cinema.sys.message;

import java.io.Serializable;

/**
 *传输的信息
 */
public class Message<T> implements Serializable {//不知道内容使用泛型
    private String action;
    private T data;
    public Message(String action, T data) {
        this.action = action;
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return  action +"=>" + data;
    }
}
