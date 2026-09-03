package com.cry.pokrmon.item;

import com.cry.pokrmon.DisplayItem;
import com.cry.pokrmon.item.Pokemon.Bikchu;
import com.cry.pokrmon.item.Pokemon.Bulbasuar;
import com.cry.pokrmon.item.Pokemon.Charmander;
import com.cry.pokrmon.item.Pokemon.Jolteon;
import com.cry.pokrmon.item.equipment.*;
import com.cry.pokrmon.util.Tools;

import java.util.Random;

/*
*宝箱
 */
public class Treasure extends Item {

    public Treasure( int levelNumber) {
        super("宝箱", levelNumber);
    }
    /*
    开启宝箱可以获得物品
     */
    public Item open(){
        return Tools.getRandomItem(levelNumber);
    }

    @Override
    public String getItemInformation() {
        return discory?"◎":"■";
    }
}
