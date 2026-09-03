public class User implements Comparable<User> {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        if(age == o.age)return 0;
        else if(age < o.age)return 1;
        else return -1;
    }
}
