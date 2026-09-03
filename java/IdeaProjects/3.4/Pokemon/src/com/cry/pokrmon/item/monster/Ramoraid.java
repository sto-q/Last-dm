package com.cry.pokrmon.item.monster;

import com.cry.pokrmon.item.Monster;
import com.cry.pokrmon.util.Tools;

public class Ramoraid extends Monster {
    public Ramoraid(int levelNumber) {
        super("冰霜怪", levelNumber);
        this.attack= Tools.getRandomNumber(40,50,levelNumber);
        this.defense= Tools.getRandomNumber(45,55,levelNumber);
        this.health= Tools.getRandomNumber(700,800,levelNumber);
        this.currentHealth= this.health;
    }
    public String getItemInformation() {
        return discory?"A":"■";
    }
}
