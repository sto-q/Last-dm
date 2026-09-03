package day14;

public class im implements Runnable{
private String name;

    public im(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=1;i<=4;i++) {
            try {
                Thread.sleep(50L);
                System.out.println(name+":"+i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    }
