package com.cry.pokrmon.item.equipment;

import com.cry.pokrmon.util.Tools;

public class Bracelet extends Equipment{
    /*
    手镯
     */
    public Bracelet(int levelNumber) {
        super("手镯", levelNumber);
        this.attack= Tools.getRandomNumber(20,30,levelNumber);
        this.defense=Tools.getRandomNumber(20,30,levelNumber);
        this.health= Tools.getRandomNumber(150,240,levelNumber);
    }
}
