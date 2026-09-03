package src.com.lmq.layar.mondel;

public class User {
    private String username;
    private String password;
    private String stal;
    public User(String username, String password, String stal) {
        this.username = username;
        this.password = password;
        this.stal = stal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStal() {
        return stal;
    }

    public void setStal(String stal) {
        this.stal = stal;
    }
}
