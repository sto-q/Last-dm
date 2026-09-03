package day7;

public class text {
    public static void main(String[] args) {
        中学生 张三=new 中学生();
        张三.设置学生信息("160101","张三",'f',15);
        张三.填写中学生成绩(90,91);
        大学生 李四=new 大学生();
        李四.设置学生信息("0416010101","李四",'m',19);
        李四.填写大学生成绩(80,81);
        张三.print();
        李四.print();
    }
}
