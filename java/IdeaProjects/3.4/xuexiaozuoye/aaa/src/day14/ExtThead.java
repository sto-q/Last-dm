package day14;

public class ExtThead extends Thread{
    public ExtThead(String name) {
        super(name);
    }
    public void run() {
        for(int i=1;i<=4;i++) {
            try {
                Thread.sleep(50L);
                System.out.println(this.getName()+":"+i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
