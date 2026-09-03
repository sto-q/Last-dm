package day7;

public class 大学生 extends 学生{
    int 高数,Java;
    void 填写大学生成绩(int math,int prog){
        高数=math;
        Java=prog;
    }
    public String 大学生成绩(){
        String str="高等数学"+高数+",Java:"+Java;
        return str;
    }
    void print(){
        System.out.print(学生信息()+"");
        System.out.println(大学生成绩());
    }
}
