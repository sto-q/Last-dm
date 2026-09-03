package day15;

public class Pick extends Thread{
    @Override
    public void run() {
            try {
                sleep(50L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        System.out.println(this.getName()+"摘了一个苹果");
    }
}
