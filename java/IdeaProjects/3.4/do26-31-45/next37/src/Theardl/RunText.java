package Theardl;

public class RunText {
    public static void main(String[] args) {
        Acont a=new Acont("AAA");
        Thread thread = new Thread(new Text1(a,500));
        Thread thread1 = new Thread(new Text2(a,1000));
        thread.start();
        thread1.start();
    }
}
