import java.util.Scanner;
public class text {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("输入整数成绩");
        int n=sc.nextInt();
        switch(n/10){
            case 10:
            case 9:
                System.out.println("优秀");
                break;
            case 8:
                System.out.println("良好");
                break;
            case 7:
                System.out.println("中等");
                break;
            case 6:
                System.out.println("合格");
                break;
            case 0:
                System.out.println("不及格");
                break;
            default:
                System.out.println("No");
        }
    }
}
