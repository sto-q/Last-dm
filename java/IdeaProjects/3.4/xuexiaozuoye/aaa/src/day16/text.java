package day16;

public class text {
    public static void main(String[] args)throws Exception {
        Thread t1=new Thread(new ReadBook1());
        Thread t2=new Thread(new ReadBook1());
        t1.setName("zhangsan");
        t2.setName("lisi");
        t1.start();
        t2.start();
        Thread.sleep(500);
        t1.interrupt();
    }
}
