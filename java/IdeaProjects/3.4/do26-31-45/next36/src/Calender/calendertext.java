package Calender;

import java.util.Calendar;
import java.util.Date;

public class calendertext {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        System.out.println(date);
        cal.roll(Calendar.DAY_OF_MONTH, 3);
        System.out.println(cal.getTime());
    }
}
