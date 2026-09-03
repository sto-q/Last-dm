package day15;

public class wash extends Thread {
    Pick pick;
    wash() {
        pick = new Pick();
        pick.setName("Tom");
    }

    @Override
    public void run() {
        try {
            pick.start();
            sleep(50L);
            pick.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(pick.getName()+"洗了一个苹果");
    }
}
