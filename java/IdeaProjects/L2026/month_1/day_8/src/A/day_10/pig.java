package A.day_10;

public class pig extends animal{
    public pig(String name, int age) {
        super(name, age);
    }
    public void eat(){
        System.out.println(name+" "+age+"eat");
    }
    public void sleep(){
        System.out.println(name+" "+age+"sleep");
    }
}
