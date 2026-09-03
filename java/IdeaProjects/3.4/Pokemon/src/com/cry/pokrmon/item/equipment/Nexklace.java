package com.cry.pokrmon.item.equipment;

import com.cry.pokrmon.util.Tools;

public class Nexklace extends Equipment{
    /*
    项链
     */
    public Nexklace(int levelNumber) {
        super("项链", levelNumber);
        this.attack= Tools.getRandomNumber(25,35,levelNumber);
        this.defense=Tools.getRandomNumber(25,35,levelNumber);
        this.health= Tools.getRandomNumber(250,300,levelNumber);
    }
}
