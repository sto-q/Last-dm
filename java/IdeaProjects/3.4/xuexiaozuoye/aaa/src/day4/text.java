package day4;

import java.util.Random;

class Village{
    String name;
    static int count=100;

    public Village(String name) {
        this.name = name;
    }
    public static int getCount(){
        return count;
    }
    void getWater(int water){
        count-=water;
    }

}
public class text {
    public static void main(String[] args) {
        Random rand = new Random();
        int randNum = rand.nextInt(10);
        Village v=new Village("A");
        v.getWater(randNum);
        System.out.println(v.name+"取了 "+randNum+"还有"+v.getCount());
        Village v1=new Village("B");
        int randNum1 = rand.nextInt(10);
        v1.getWater(randNum1);
        System.out.println(v1.name+"取了 "+randNum1+"还有"+v.getCount());
        Village v2=new Village("C");
        int randNum2 = rand.nextInt(10);
        v2.getWater(randNum2);
        System.out.println(v2.name+"取了"+randNum2+"还有"+v.getCount());
    }
}
