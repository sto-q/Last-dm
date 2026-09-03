package com.cry.pokrmon.item.monster;

import com.cry.pokrmon.item.Monster;
import com.cry.pokrmon.util.Tools;

public class Mamoswine extends Monster {
    public Mamoswine( int levelNumber) {
        super("噬魂兽", levelNumber);
        this.attack= Tools.getRandomNumber(55,60,levelNumber);
        this.defense= Tools.getRandomNumber(40,60,levelNumber);
        this.health= Tools.getRandomNumber(1300,1800,levelNumber);
        this.currentHealth= this.health;
    }

    @Override
    public String getItemInformation() {
        return discory?"D":"■";
    }
}
