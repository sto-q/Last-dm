package Calender.MyCalendar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.Consumer;

public class myCalendar {
    private static final String[] week={"一","二","三","四","五","六","日"};
    private static final int Total=42;//
    private List<DayInfo> getDayMyCalender(int year,int month){
        List<DayInfo> Day=new ArrayList<>(Total);
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        int currentDisplayDay=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);//这个月MAX
        calendar.set(Calendar.DAY_OF_MONTH,1);//这个月从第一天开始
        int weekDay=calendar.get(Calendar.DAY_OF_WEEK);//第一天是从星期几开始的
        int lastweekDay=weekDay-2;//前一个月从星期几开始
        if(lastweekDay<0){
            lastweekDay+=7;//星期六开始
        }
        calendar.add(Calendar.DAY_OF_MONTH,-1);//移动到前一个月
        int lastMaxday=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);//获取前一个月MAX
        int lastshowDay=lastMaxday-lastweekDay+1;
        for(int i=lastshowDay;i<=lastMaxday;i++){
            Day.add(new DayInfo(i,false));
        }
        calendar.add(Calendar.MONTH, 1);
        for(int i=1;i<currentDisplayDay;i++){
            Day.add(new DayInfo(i,true));
        }
        int nextDay=Total-currentDisplayDay-lastMaxday+lastshowDay;//下一个月
        for(int i=1;i<=nextDay;i++){
            Day.add(new DayInfo(i,false));
        }
        return Day;
    }
    private void showDay(int year,int month){
//        Arrays.stream(week).forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.print(s+"\t");
//            }
//        });
        Arrays.stream(week).forEach(s -> System.out.print(s+"\t"));
        System.out.println();
        List<DayInfo>days=getDayMyCalender(year, month);
        for(int i=0;i<days.size();i++){
            DayInfo d=days.get(i);
            d.show();
            if((i+1)%7==0){
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        myCalendar myCalendar=new myCalendar();
        myCalendar.showDay(2026,4);
    }
}
