package lmq.cyx.cinema.sys.util;

import lmq.cyx.cinema.sys.entity.FilmPlan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    /**
     * 日期转字符串
     * @param d
     * @return
     */
    public static String data2Srt(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    /**
     * 字符串转日期
     * @param datestr
     * @return
     */
    public static  Date str2Data(String datestr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(datestr);
    }
    public static boolean isConflicPlan(FilmPlan filmPlan1, FilmPlan filmPlan2){
        Date begin1 = filmPlan1.getBegin();
        Date begin2 = filmPlan2.getBegin();
        Date end1 = filmPlan1.getEnd();
        Date end2 = filmPlan2.getEnd();
        if(filmPlan1.getFilmHall().equals(filmPlan2.getFilmHall())){
            boolean case1=begin2.before(begin1)&&end2.after(begin1)&&end2.after(end1);
            boolean case2=begin2.after(begin1)&&begin2.after(end2)&&end2.after(end1);
            boolean case3=begin2.after(begin1)&&begin2.after(end2)&&end2.after(end1);
            return case1||case2||case3;
        }
        return false;
    }
}
