import java.util.Scanner;

public class opp {
    public static muen[] one={
            new muen(1,"学生成绩管理"),
            new muen(2,"学生成绩查寻"),
            new muen(3,"退出系统")
    };
    public static muen[] two={
            new muen(1,"增加"),
            new muen(2,"修改"),
            new muen(3,"删除"),
            new muen(4,"查询"),
            new muen(5,"返回主菜单"),
    };
    public static Scanner sc=new Scanner(System.in);
    public static User user=new User();
    public static void gotomain(){
        show(one);
        int sum=sc.nextInt();
        if(sum==1){
            gototwo();
        }else if(sum==2){
            System.out.println("选课系统");
            gotomain();
        }else{
            System.out.println("感谢使用");
        }
    }
    public static void show(muen[] muens){
        for(int i=0;i<muens.length;i++){
            muens[i].show();
        }
    }
    public static void gototwo(){
        show(two);
        int sum=sc.nextInt();
        switch(sum){
            case 1:
            user.zheng();
            gotomain();
            break;
            case 2:
           user.gai();
                gotomain();
            break;
            case 3:
            user.shan();
                gotomain();
            break;
            case 4:
            user.cha();
                gotomain();
            break;
            case 5:
                gotomain();
                break;
        }
    }
public static void main(String[] args){
        gotomain();
}
}
