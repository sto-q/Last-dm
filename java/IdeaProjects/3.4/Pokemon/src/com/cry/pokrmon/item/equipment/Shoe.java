package com.cry.pokrmon.item.equipment;

import com.cry.pokrmon.util.Tools;

public class Shoe extends Equipment{
    /*
    靴子
     */
    public Shoe(int levelNumber) {
        super("靴子", levelNumber);
        this.attack= 0;
        this.defense= Tools.getRandomNumber(10,20,levelNumber);
        this.health= Tools.getRandomNumber(100,150,levelNumber);
    }
}
