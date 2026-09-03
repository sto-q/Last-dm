package A.day_10;

public class dog extends animal{
    public dog(String name,int age){
        super(name,age);
    }
    public void eat(){
        System.out.println(age+name+" is eating");
    }
    public void sleep(){
        System.out.println(age+name+" is sleeping");
    }
}
