package day11;

public class text {
    public static void main(String[] args) {
        Person person = new Person();
        person.doing();
        person=new Person(){
            public void doing(){
                System.out.println("学生们正在学习");
            }
        };
        person.doing();
        person=new Person(){
            public void doing(){
                System.out.println("环卫工人正在清洁");
            }
        };
        person.doing();
        person=new Person(){
            public void doing(){
                System.out.println("skdlfmslkf");
            }
        };
        person.doing();
    }
}
