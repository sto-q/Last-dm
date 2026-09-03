package day16;

public class ReadBook1 implements Runnable{
    private int pageCount=0;
    @Override
    public void run() {
        try{
            while(pageCount<100){
                System.out.println(Thread.currentThread().getName()+"is reading");
                pageCount+=20;
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"read the first "+(pageCount-20)+" pages.");
            System.out.println(Thread.currentThread().getName()+"'s reading was interrupted !");
        }
    }
}
