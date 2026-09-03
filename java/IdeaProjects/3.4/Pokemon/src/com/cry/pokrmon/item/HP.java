package com.cry.pokrmon.item;
/*
药品
 */
public class HP extends Item{
    private int count;
    public HP( int levelNumber,int count) {
        super("气血丸", levelNumber);
        this.count = count;
    }
    /*
    使用药品
     */
    public int use(){
        count--;
        return levelNumber*500;
    }
    /*
    检测药品是否可以被销毁
     */
    public boolean canDestroy(){
        return count == 0;
    }
    public void addCount(int count){
            this.count += count;
    }
    public int getCount() {
        return count;
    }

//    @Override
//    public String getItemInformation() {
//        return name;
//    }
@Override
public String getItemInformation() {
    return discory?"◎":"■";
}
}
