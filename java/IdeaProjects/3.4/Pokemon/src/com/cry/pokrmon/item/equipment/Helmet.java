package com.cry.pokrmon.item.equipment;

import com.cry.pokrmon.util.Tools;

public class Helmet extends Equipment{
    /*
    头盔
     */
    public Helmet( int levelNumber) {
        super("头盔", levelNumber);
        this.attack= 0;
        this.defense= Tools.getRandomNumber(20,30,levelNumber);
        this.health= Tools.getRandomNumber(200,300,levelNumber);
    }
}
