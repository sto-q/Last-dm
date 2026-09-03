package lmq.cyx.cinema.sys.util;

import lmq.cyx.cinema.sys.menu.MenuManager;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);

    /**
     *
     * @param tip 提示词
     * @param min
     * @param max
     * @return
     */
    public static int getInputInttegrt(String tip,int min,int max){
        System.out.println(tip);
        while (true) {
            if(sc.hasNextInt()) {
                int number = sc.nextInt();
                if(number >= min&&number <=max ) {
                    return number;
                }else {
                    System.out.printf("请输入%d到%d的数字\n",min,max);
                }
            }else{
                System.out.printf("请输入%d到%d的数字\n",min,max);
                sc.next();
            }
        }
    }

    /**
     * 从控制台获取一个字符串
     * @param tip 提示信息
     * @return
     */
    public static String getInputText(String tip){
        System.out.println(tip);
        return sc.next();
    }

    /**
     * 从控制台获取一个日期
     * @param tip
     * @return
     */
    public static Date getInputDate(String tip){
        System.out.println(tip);
        while (true) {
            String dateStr = sc.nextLine();
            try {
                return DataUtil.str2Data(dateStr);
            } catch (ParseException e) {
                System.out.println("输入错误，请重新输入，日期格式为：yyyy-MM-dd HH:mm:ss");
            }
        }
    }
}
