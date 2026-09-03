public class Student {
    String name;
    int age;
    int xx;

    public String getName() {
        return name;
    }

    public int getXx() {
        return xx;
    }

    public int getAge() {
        return age;
    }

    public Student(String name, int age, int xx){
        this.name=name;
        this.age=age;
        this.xx=xx;
    }
    public void show(){
        System.out.println(name+" "+age+" "+xx);
    }
}
