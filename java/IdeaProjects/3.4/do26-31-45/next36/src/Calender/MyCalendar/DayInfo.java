package Calender.MyCalendar;

public class DayInfo {
    private int day;
    private boolean currmonth;

    public DayInfo(int day, boolean currmonth) {
        this.day = day;
        this.currmonth = currmonth;
    }

    public int getDay() {
        return day;
    }

    public boolean isCurrmonth() {
        return currmonth;
    }

    public void setCurrmonth(boolean currmonth) {
        this.currmonth = currmonth;
    }
        public synchronized void show(){
        if(currmonth){
            System.out.print(day+"\t");
        }else {
            System.err.print(day+"\t");
        }
            try{
                Thread.sleep(7L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
