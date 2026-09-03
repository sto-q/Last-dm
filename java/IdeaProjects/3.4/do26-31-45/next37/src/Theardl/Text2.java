package Theardl;

public class Text2 implements Runnable {
    private Acont  acont;
    private double money;
    public Text2(Acont acont, double money) {
        this.acont = acont;
        this.money = money;
    }
    @Override
    public void run() {
        while (true) {
            acont.dram(money);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
