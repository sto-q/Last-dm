package Theardl;

public class Acont {
    private String name;
    private double price;
    private boolean open=false;

    public Acont(String name) {
        this.name = name;
    }
    public synchronized void store(double money) {
        if(open){
            System.out.println(name +"的老爸等待通知存钱");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            price+=money;
            System.out.println(name + "的老爸存了" + money+ "元钱");
            open=true;
            notify();
        }
    }
    public synchronized void dram(double money) {
        if(open){
            if(money>price){
                System.out.println(name + "向他老爸控诉没有钱了");
                open=false;
                notify();
            }else{
                price-=money;
                System.out.println(name + "取了" + money + "元钱");
            }
        }else {
            try{
                System.out.println(name + "等待他老爸存钱");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
