package A.day_10;

public class animal {
    protected String name;
    protected int age;
    public animal(String name,int age){
        super();
        this.name=name;
        this.age=age;
    }
    public void eat(){
        System.out.println("eat");
    }
    public void sleep(){
        System.out.println("sleep");
    }
}
