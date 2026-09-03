public class Threadtext {
    public static void main(String[] args) {
        Thread t1 = new RunThread("Aa");
        Thread t2 = new Thread(new RunThread2(),"asd");
        t1.start();
        t2.start();
    }
    static class RunThread extends Thread {
        private String threadName;
        public RunThread(String threadName) {
            this.threadName = threadName;
        }
        @Override
        public void run() {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(threadName+" is running");
        }
    }
    static class RunThread2 extends Thread {
        @Override
        public void run() {
            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+" is running");
        }
    }
}
