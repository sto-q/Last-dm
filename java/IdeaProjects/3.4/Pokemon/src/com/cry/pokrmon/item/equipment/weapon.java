package com.cry.pokrmon.item.equipment;

import com.cry.pokrmon.util.Tools;

public class weapon extends Equipment{
    /*
    武器
     */
    public weapon(int levelNumber) {
        super("武器", levelNumber);
        this.attack= Tools.getRandomNumber(100,150,levelNumber);
        this.defense=0;
        this.health= Tools.getRandomNumber(200,300,levelNumber);
    }
}
