public class yishen extends people{
    public yishen(String name, int age){
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("yiShen-eat");
    }
    public void sleep(){
        System.out.println("yiShen-sleep");
    }
}
