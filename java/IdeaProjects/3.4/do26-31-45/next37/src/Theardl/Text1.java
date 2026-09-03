package Theardl;

import javax.swing.*;

public class Text1 implements Runnable {
    private Acont  acont;
    private double money;
    public Text1(Acont acont, double money) {
        this.acont = acont;
        this.money = money;
    }
    @Override
    public void run() {
        while (true) {
            acont.store(money);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
