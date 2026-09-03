package day17;

public class User {
    private String code;
    private int cash;

    public User(String code, int cash) {
        this.code = code;
        this.cash = cash;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public synchronized void operate(int  x){
        try{
            Thread.sleep(10);
            this.cash += x;
            String TheadName = Thread.currentThread().getName();
            System.out.println(TheadName + "结束，增加" +x+",账号余额为"+ this.cash);
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "code='" + code + '\'' +
                ", cash=" + cash +
                '}';
    }
}
