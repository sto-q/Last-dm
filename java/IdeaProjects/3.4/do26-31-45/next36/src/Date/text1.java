package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class text1 {
    public static void main(String[] args) {
//        Date time=new Date();
//        System.out.println(time);
        long startTime = System.currentTimeMillis();
        Date time=new Date(startTime);
        System.out.println(time);
       long nowdate=time.getTime();
        System.out.println(nowdate);
        String SS=String.valueOf(nowdate);
        long last3time=nowdate-3*24*60*60*1000;
        Date Last3Time=new Date(last3time);
        System.out.println(Last3Time.after(time));//L是否在time后
        System.out.println(Last3Time.before(time));//L是否在time前
        soreTime(Last3Time,SS);
    }
    public static void soreTime(Date S,String time){
        String a="YYYY-MM-dd";
        String b="YYYY-MM-dd HH:mm:ss";
        String c="YYYY-MM-dd HH:mm";
        String d="YYYY年-MM月-dd日";
        Date Time=text1.soreDate(time,b);
        System.out.println(Time);
    }
    public static Date soreDate(String patten,String date){
        SimpleDateFormat sdf=new SimpleDateFormat(patten);
        try{
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
