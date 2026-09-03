package com.cry.pokrmon.item.monster;

import com.cry.pokrmon.item.Monster;
import com.cry.pokrmon.util.Tools;

public class CattleMonster extends Monster {
    public CattleMonster(int levelNumber) {
        super("魔岩兽", levelNumber);
        this.attack= Tools.getRandomNumber(60,80,levelNumber);
        this.defense= Tools.getRandomNumber(45,65,levelNumber);
        this.health= Tools.getRandomNumber(900,1000,levelNumber);
        this.currentHealth= this.health;
    }

    @Override
    public String getItemInformation() {
        return discory?"C":"■";
    }
}
