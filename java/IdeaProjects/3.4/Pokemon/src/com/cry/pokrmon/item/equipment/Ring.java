package com.cry.pokrmon.item.equipment;

import com.cry.pokrmon.util.Tools;

public class Ring extends Equipment{
    /*
    戒指
     */
    public Ring(int levelNumber) {
        super("戒指", levelNumber);
        this.attack= Tools.getRandomNumber(20,30,levelNumber);
        this.defense=Tools.getRandomNumber(20,30,levelNumber);
        this.health= Tools.getRandomNumber(200,300,levelNumber);
    }
}
