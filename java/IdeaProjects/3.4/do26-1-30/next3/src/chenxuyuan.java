public class chenxuyuan extends people{
    String EE;
    public chenxuyuan(String name, int age, String ee) {
        super(name, age);
        EE = ee;
    }
    public void eat(){
        System.out.println("chenxuyuan"+EE+"-eat-eat");
    }
    public void sleep(){
        System.out.println("chenxuyuan+"+EE+"-sleep-sleep");
    }
}
