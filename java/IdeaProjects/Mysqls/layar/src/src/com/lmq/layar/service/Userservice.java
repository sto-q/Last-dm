package src.com.lmq.layar.service;

public interface Userservice {
    String register(String username, String password);
    String login(String username, String password);
}
