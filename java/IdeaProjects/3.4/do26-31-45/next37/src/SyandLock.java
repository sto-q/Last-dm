import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyandLock {
    public static void main(String[] args) {
        SA sa = new SA();
        Thread A = new Thread(sa,"A");
        Thread B = new Thread(sa,"B");
        Thread C = new Thread(sa,"C");
        A.start();
        B.start();
        C.start();
    }
//    static class SA  implements Runnable {
//        private int Total=10;
//        public  void run() {
//        while(true){
//            String name=Thread.currentThread().getName();
//            System.out.println(name+" "+Total);
//            Total--;
//            if(Total<=0){
//                break;
//            }
//            try {
//                Thread.sleep(10L);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        }
//    }
static class SA  implements Runnable{
    private int Total=10;
//    private synchronized void increase(){
//        if(Total>0){
//            String name=Thread.currentThread().getName();
//            System.out.println(name + " Entered "+Total);
//            Total--;
//        }
//    }
//    @Override
//    public void run() {
//        while(true){
//            increase();
//            if(Total<=0){
//                break;
//            }
//            try {
//                Thread.sleep(10L);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        }
//    }
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            if(lock.tryLock()){
                try{
                    if(Total>0){
                        System.out.println(Thread.currentThread().getName()+"\t"+Total);
                        Total--;
                    }
                }finally{
                    lock.unlock();
                }
            }
            if(Total==0){
                break;
            }
            try{
                Thread.sleep(5L);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    }
}
