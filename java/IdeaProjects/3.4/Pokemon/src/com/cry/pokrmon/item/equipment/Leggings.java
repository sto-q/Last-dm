package com.cry.pokrmon.item.equipment;

import com.cry.pokrmon.util.Tools;

public class Leggings extends Equipment{
    /*
    护腿
     */
    public Leggings(int levelNumber) {
        super("护腿", levelNumber);
        this.attack= 0;
        this.defense= Tools.getRandomNumber(30,40,levelNumber);
        this.health= Tools.getRandomNumber(200,300,levelNumber);
    }
}
