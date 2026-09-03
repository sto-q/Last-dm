package com.cry.pokrmon.item.equipment;

import com.cry.pokrmon.util.Tools;

public class Armor extends Equipment{
    /*
    铠甲
     */
    public Armor(int levelNumber) {
        super("铠甲", levelNumber);
        this.attack= 0;
        this.defense= Tools.getRandomNumber(40,50,levelNumber);
        this.health= Tools.getRandomNumber(300,400,levelNumber);
    }
}
