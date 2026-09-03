import java.io.Serializable;
public class student implements Serializable {
    private String name;
    private int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void show(){
        System.out.println("Name: " + name+"\nAge: " + age);
    }
}
