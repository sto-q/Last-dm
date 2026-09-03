package day7;
class 学生 {
    String 学号;
    String 姓名;
    char 性别;
    int 年龄;
    void 设置学生信息(String no,String name,char gender,int age){
        学号=no;
        姓名=name;
        性别=gender;
        年龄=age;
    }
    public String 学生信息(){
        String str=学号+""+姓名+"";
        str+=(性别=='m'?"男":"女")+年龄+"岁";
        return str;
    }
}
