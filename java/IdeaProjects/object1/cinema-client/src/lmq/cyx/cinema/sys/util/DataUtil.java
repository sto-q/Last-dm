package lmq.cyx.cinema.sys.util;

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
}
