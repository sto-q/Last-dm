package List;

public class Student {
    private String name;
    private int age;
    private  String sex;
    private Double Score;

    public Student(String name, int age, String sex,Double score) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        Score = score;
    }

    @Override
    public String toString() {
        return name+","+age+","+sex+","+Score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getScore() {
        return Score;
    }

    public void setScore(Double score) {
        Score = score;
    }
}
