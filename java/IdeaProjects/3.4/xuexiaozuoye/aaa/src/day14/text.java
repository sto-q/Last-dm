package day14;

public class text {
    public static void main(String[] args) {
        Thread t1=new ExtThead("A");
        Thread t2=new ExtThead("B");
        t1.start();
        t2.start();
    }
}
