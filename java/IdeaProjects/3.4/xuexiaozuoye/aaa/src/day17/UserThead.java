package day17;

public class UserThead extends Thread {
    private User user;
    private int y=0;
    public UserThead(String name, User user, int y) {
        super(name);
        this.user = user;
        this.y = y;
    }
    public void run() {
        user.operate(y);
    }
}
