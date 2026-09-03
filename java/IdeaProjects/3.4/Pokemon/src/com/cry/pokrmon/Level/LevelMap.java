package com.cry.pokrmon.Level;

import com.cry.pokrmon.Adventurer;
import com.cry.pokrmon.DisplayItem;
import com.cry.pokrmon.item.Item;
import com.cry.pokrmon.item.Monster;
import com.cry.pokrmon.item.Treasure;
import com.cry.pokrmon.item.monster.CattleMonster;
import com.cry.pokrmon.item.monster.Mamoswine;
import com.cry.pokrmon.item.monster.Ramoraid;
import com.cry.pokrmon.item.monster.molters;
import com.cry.pokrmon.item.portal;
import com.cry.pokrmon.util.Tools;

/*
关卡地图
 */
public class LevelMap {
private int level;
    public final DisplayItem[][] items = new DisplayItem[9][9];
    public LevelMap(int level) {
        this.level = level;
        generatemap();
    }
//    public void L(){
//        for(int i = 0; i < items.length; i++){
//            for(int j = 0; j < items[i].length; j++){
//                items[i][j]=new molters(level);
//            }
//        }
//    }
    private int currentRow, currentCol;
    public void generatemap() {
        if(level == 1) {
            items[0][1]=new Mamoswine(level);
            items[0][0]=new Mamoswine(level);
        }else {
            //其他关卡第一个位置为返回上一关的传送门
            items[0][0]=new portal(false);
            items[0][1] = new portal(false);
        }
        int generaterTreasure = 0;//记录生成宝箱数
        int generatermonster1 = 0;//记录生成怪物数
        int generatermonster2 = 0;
        int generatermonster3 = 0;
        int generatermonster4 = 0;
        int generaterportal = 0;//记录生成的传送门数
        while (generaterTreasure <39||(generatermonster1+generatermonster2+generatermonster3+generatermonster4) < 39||generaterportal ==0) {
            //获取随机坐标
            int index= Tools.getRandomNumber(2, 81);
            int row=index/items[0].length;
            int col=index%items[0].length;
            //位置已经被占
            if(items[row][col]!=null) continue;
            //获取随机数
            int rate=Tools.getRandomNumber(79);
            if(rate==0){//传送门
                if(generaterportal==1)continue;//传送门已经生成了直接跳过
                items[row][col]=new portal(true);
                generaterportal+=1;
            } else if (rate<40) {//宝箱
                if(generaterTreasure==39)continue;//宝箱已经生成完了
                items[row][col]=new Treasure(level);
                generaterTreasure+=1;
            }else{//怪物 初级，中级 高级 终极= 18.12.6.3
                int num=Tools.getRandomNumber(39);
                if(num<3){
                    if(generatermonster4==3)continue;
                    items[row][col]=new Mamoswine(level);
                    generatermonster4+=1;
                } else if (num<9) {
                    if(generatermonster3==6)continue;
                    items[row][col]=new CattleMonster(level);
                    generatermonster3+=1;
                } else if (num<21) {
                    if(generatermonster2==12)continue;
                    items[row][col]=new molters(level);
                    generatermonster2+=1;
                } else {
                    if(generatermonster1==18)continue;
                    items[row][col]=new Ramoraid(level);
                    generatermonster1+=1;
                }
            }
        }
    }
    public void show(){
        System.out.println("宠物小精灵第" + level + "关：");
        for(int i=0; i<items.length; i++){
            String line1 = "", line2 = "";
            for(int j=0; j<items[i].length; j++){
                String info = " ";
                if(items[i][j] != null){
                    info = items[i][j].getItemInformation();
                }
                if(i == 0){//第一行
                    if(j == 0){//第一列
                        line1 += "┌───";
                        line2 += "│ " + info + " ";
                    } else if(j == items[i].length-1){//最后一列
                        line1 += "┬───┐";
                        line2 += "│ " + info + " │";
                    } else {
                        line1 += "┬───";
                        line2 += "│ " + info + " ";
                    }
                } else {
                    if(j == 0){//第一列
                        line1 += "├───";
                        line2 += "│ " + info + " ";
                    } else if(j == items[i].length-1){//最后一列
                        line1 += "┼───┤";
                        line2 += "│ " + info + " │";
                    } else {
                        line1 += "┼───";
                        line2 += "│ " + info + " ";
                    }
                }
            }
            System.out.println(line1);
            System.out.println(line2);
        }
        String lastLine = "";//最后一行网格线
        for(int i=0;i<items[0].length; i++){
            if(i==0){//第一列
                lastLine += "└───";
            } else if(i == items[0].length -1){//最后一列
                lastLine += "┴───┘";
            } else {
                lastLine += "┴───";
            }
        }
        System.out.println(lastLine);
    }
    public DisplayItem getPosititionItem(char direct) {
        int targetRow=currentRow,targetCol=currentCol;
        switch (direct) {
            case 'W':
                if(targetRow==0){
                    return null;
                }
                targetRow-=1;
                break;
                case 'S':
                    if(targetCol==items.length-1){
                        return null;
                    }
                    targetRow+=1;
                    break;
                    case 'A':
                        if(currentCol==0){
                            return null;
                        }
                        targetCol-=1;
                        break;
                        case 'D':
                            if(targetCol==items[currentRow].length-1){
                                return null;
                            }
                            targetCol+=1;
                            break;
        }
        return items[targetRow][targetCol];
    }
    public void move(char direct) {
        int oldRow=currentRow;
        int oldCol=currentCol;
        DisplayItem adventure =items[oldRow][oldCol];
        switch (direct) {
            case 'W':
                if(currentRow==0){
                    System.err.println("非法移动");
                            Tools.lazy(300L);
                    return;
                }
                currentRow-=1;
                break;
            case 'S':
                if(currentCol==items.length-1){
                    System. err.println("非法移动");
                    Tools.lazy(300L);
                    return;
                }
                currentRow+=1;
                break;
            case 'A':
                if(currentCol==0){
                    System.err.println("非法移动");
                    Tools.lazy(300L);
                    return ;
                }
                currentCol-=1;
                break;
            case 'D':
                if(currentCol==items[currentRow].length-1){
                    System.err.println("非法移动");
                    Tools.lazy(300L);
                    return;
                }
                currentCol+=1;
                break;
        }
        items[currentRow][currentCol]=adventure;
        items[oldRow][oldCol]=null;
    }
    public void addAdventurer(Adventurer adventurer) {
        currentRow=0;
        if(level==1) {
            currentCol=0;
            items[0][0]=adventurer;
        } else   {
            currentCol=1;
            items[currentRow][currentCol]=adventurer;
        }
    }
//    public static void main(String[] args) {
//        LevelMap levelMap = new LevelMap(2);
//        levelMap.show();
//
//    }
}
