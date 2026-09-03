import java.util.Scanner;
public class next {
    public static user user=new user();
    public static Menu[] mainMenus = {
            new Menu(1, "学生成绩管理"),
            new Menu(2, "学生选课管理"),
            new Menu(3, "退出系统")
    };
    public static Menu[] secondMenus = {
            new Menu(1, "增加成绩"),
            new Menu(2, "修改成绩"),
            new Menu(3, "删除成绩"),
            new Menu(4, "查询成绩"),
            new Menu(5, "返回主菜单")
    };
    public static void main(String[] args) {
        one();
    }
    public static void one() {
        Scanner sc=new Scanner(System.in);
        show(mainMenus);
        int number=sc.nextInt();
        if(number==1) {
            two();
        }else if(number==2) {
            System.out.println("选课管理");
            one();
        }else if(number==3) {
            System.out.println("感谢使用XXX系统");
        }
    }
    public static void two() {
        Scanner sc=new Scanner(System.in);
        show(secondMenus);
        int number=sc.nextInt();
        switch (number){
            case 1:
                user.addScore();//用户增加成绩
                two();
                break;
            case 2:
                user.updateScore();//用户修改成绩
                two();
                break;
            case 3:
                user.deleteScore();//用户删除成绩
                two();
                break;
            case 4:
                user.searchScore();//用户查询成绩
                two();
                break;
            case 5:
                one();
                break;
    }
    }
        public static void show(Menu[] menus){
            for(int i=0; i<menus.length; i++){
                menus[i].show();
            }
            System.out.println("请选择菜单编号：");
        }
}
