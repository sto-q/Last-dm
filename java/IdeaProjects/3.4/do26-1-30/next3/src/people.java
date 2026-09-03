public class people {
    protected String name;
    protected int age;
    //public people(){}
    public people(String name, int age){
        this.name=name;
        this.age=age;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void eat(){
        System.out.println("eat-eat-eat");
    }
    public void sleep(){
        System.out.println("sleep-sleep-sleep");
    }
    public void show(){
        System.out.println("Name: "+name+" Age: "+age);
    }
}
