package com.cry.pokrmon.util;

import com.cry.pokrmon.item.HP;
import com.cry.pokrmon.item.Item;
import com.cry.pokrmon.item.Pokemon.Bikchu;
import com.cry.pokrmon.item.Pokemon.Bulbasuar;
import com.cry.pokrmon.item.Pokemon.Charmander;
import com.cry.pokrmon.item.Pokemon.Jolteon;
import com.cry.pokrmon.item.equipment.*;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Tools {
    private static  final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);
//    public static char getinputChar() {
//            char input;
//            try {
//                input = (char) System.in.read();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            return input;
//    }
    public static char getinputChar() {
        while(true) {
            String input = SCANNER.next().trim();
            if(input.length() != 1) {
                System.out.println("输入错误");
            }else {
                return input.charAt(0);
            }
        }
    }
//public static char getinputChar() {
//    Scanner scanner = new Scanner(System.in);
//
//    while (true) {
//        System.out.print("请输入一个字符: ");
//        String input = scanner.nextLine().trim();
//
//        if (input.length() == 1) {
//            return input.charAt(0);
//        } else if (input.length() > 1) {
//            System.out.println("只能输入一个字符，已取第一个字符: " + input.charAt(0));
//            return input.charAt(0);
//        } else {
//            System.out.println("输入不能为空，请重新输入！");
//        }
//    }
//}
    public static int getRandomNumber(int min,int max,int levelNumber){
        int diff = (max - min)*levelNumber;
        return RANDOM.nextInt(diff)+min*levelNumber;
    }

    public static int getRandomNumber(int min,int max){
        return getRandomNumber(min,max,1);
    }
    public static int getRandomNumber(int max) {
        return getRandomNumber(0,max);
    }
/*
获取随机物品
 */
    public static Item getRandomItem(int levelNumber){
        int number = Tools.getRandomNumber(10);
        if(number == 0){//获得精灵
            int rate = Tools.getRandomNumber(100);
            if(rate == 0){
                return new Bikchu();
            } else if (rate<=4) {
                return new Charmander();
            } else if (rate<=20) {
                return new Jolteon();
            }else{
                return new Bulbasuar();
            }
        } else if (number<=3) {//获得装备
            int rate = Tools.getRandomNumber(100);
            if(rate <3){
                return new weapon(levelNumber);
            } else if (rate<8) {
                return new Nexklace(levelNumber);
            } else if (rate<16) {
                return new Ring(levelNumber);
            } else if (rate<24) {
                return new Bracelet(levelNumber);
            } else if (rate<42) {
                return new Helmet(levelNumber);
            } else if (rate<62) {
                return new Armor(levelNumber);
            } else if (rate<81) {
                return new Leggings(levelNumber);
            }else {
                return new Shoe(levelNumber);
            }
        }else{//获得药品
            return new HP(levelNumber,10);
        }
    }
    // 从控制台获取数字
    public static int getInputNumber(int min,int max){
        while(true){
            if(SCANNER.hasNextInt()){
                int number = SCANNER.nextInt();
                if(number >= min && number <= max){
                    return number;
                }else {
                    System.out.println(" 请输入"+min+"_-"+max);
                }
            } else {
                System.out.println(" 请输入"+min+"_-"+max);
                SCANNER.next();
            }
        }
    }
    //延迟时间
    public static void lazy(long time){
        try{
            Thread.sleep(300l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
