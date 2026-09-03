package com.cry.pokrmon.item.equipment;

import com.cry.pokrmon.item.Item;
/*
装备
 */
public abstract class Equipment extends Item {
    protected int attack;//攻击力
    protected int defense;//防御力
    protected int health;//生命值
    public Equipment(String name, int levelNumber) {
        super(name, levelNumber);
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String getItemInformation() {
        return name+"  攻击力:"+attack+"防御力:"+defense+"生命值:"+health;
    }
    /*
    比较装备
     */
    public boolean isBetter(Equipment other) {
        if(this.getClass() == other.getClass()) {
            int total1=this.attack+this.defense+this.health>>1;
            int total2=other.attack+other.defense+other.health>>1;
            return total1<total2;
        }
        return false;
    }
}
