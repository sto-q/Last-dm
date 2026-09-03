package DeathLock;

import java.util.Optional;

public class text1 {
    public static void main(String[] args) {
        Object o1=new Object();
        Object o2=new Object();
        Dead A=new Dead(o1,o2,0);
        Dead B=new Dead(o1,o2,1);
        Thread t1=new Thread(A);
        Thread t2=new Thread(B);
        t1.start();
        t2.start();
    }
static class Dead implements Runnable {
    private Object obj1, obj2;
    private int counter;

    public Dead(Object obj1, Object obj2, int counter) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.counter = counter;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if(counter ==0) {
            synchronized (obj1) {
                System.out.println(name + "锁定对象o1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                synchronized (obj2) {
//                    System.out.println(name + "锁定对象o2");
//                }
                //发生死锁现象因为如果从o1开始o1锁了sleep时o2开始执行o2锁了在sleep完前o1sleep结束但o2已经被后面的锁住了就会造成死锁
            }
            synchronized (obj2) {
                System.out.println(name + "锁定对象o2");
            }
        }else {
            synchronized (obj2) {
                System.out.println(name + "锁定对象o2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj1) {
                    System.out.println(name + "锁定对象o1");
                }
            }
        }
    }
    }
}