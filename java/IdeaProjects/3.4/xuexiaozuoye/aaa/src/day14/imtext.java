package day14;

public class imtext {
    public static void main(String[] args) {
        im d1=new im("A");
        im d2=new im("B");
        Thread t1=new Thread(d1);
        Thread t2=new Thread(d2);
        t1.start();
        t2.start();
    }
}
