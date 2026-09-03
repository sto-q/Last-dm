package Executo;

import java.util.concurrent.*;

public class text {
    public static void main(String[] args) {
        LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(10);
        ThreadPoolExecutor pool=new ThreadPoolExecutor(
                5,
                10,
                2,
                TimeUnit.SECONDS,queue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 30; i++) {
            pool.submit(new ThreadPoolTask(i));
            int corepoolSize = pool.getCorePoolSize();
            int Size=pool.getQueue().size();
            long finshed=pool.getCompletedTaskCount();
            System.out.printf("线程池中核心线程数：%d,队列中任务个数：%d,线程池完成任务数：%d\n",
                    corepoolSize, Size, finshed);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        pool.shutdown();
    }
    static class ThreadPoolTask implements Runnable {
        private int num;
        public ThreadPoolTask(int num) {
            this.num = num;
        }
        @Override
        public void run() {
            System.out.println("执行"+num);
            try{
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
