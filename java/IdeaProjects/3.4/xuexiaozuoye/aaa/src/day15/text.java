package day15;

public class text {
    public static void main(String[] args) {
        wash wash = new wash();
        wash.setName("Sawyer");
        wash.start();
        Thread.currentThread().setName("Billy");
        try{
            wash.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"吃了一个苹果");
    }
}
