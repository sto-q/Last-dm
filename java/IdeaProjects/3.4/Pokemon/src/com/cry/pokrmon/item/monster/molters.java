package com.cry.pokrmon.item.monster;

import com.cry.pokrmon.item.Monster;
import com.cry.pokrmon.util.Tools;

public class molters extends Monster {
    public molters(int levelNumber) {
        super("暗夜怪", levelNumber);
        this.attack= Tools.getRandomNumber(50,60,levelNumber);
        this.defense= Tools.getRandomNumber(45,50,levelNumber);
        this.health= Tools.getRandomNumber(700,800,levelNumber);
        this.currentHealth= this.health;
    }
    public String getItemInformation() {
        return discory?"B":"■";
    }
}
