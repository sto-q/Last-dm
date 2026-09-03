package day7;

public class 中学生 extends 学生{
    int 数学,语文;
    void 填写中学生成绩(int math,int chinese){
        数学=math;
        语文=chinese;
    }
    public String 中学生成绩(){
        String str="数学:"+ 数学+"语文:"+ 语文;
        return str;
    }
    void print(){
        System.out.print(学生信息()+" ");
        System.out.println(中学生成绩());
    }
}
