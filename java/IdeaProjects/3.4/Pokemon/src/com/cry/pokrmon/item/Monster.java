package com.cry.pokrmon.item;

import com.cry.pokrmon.DisplayItem;
import com.cry.pokrmon.item.Pokemon.pokemon;
import com.cry.pokrmon.util.Tools;

/*
怪物
 */
public  abstract class  Monster extends Item {
    protected int attack;//攻击力
    protected int defense;//防御力
    protected int health;//生命值
    /*
当前生命值
 */
    protected int currentHealth;
    public Monster(String name, int levelNumber) {
        super(name, levelNumber);
    }

    public int getDefense() {
        return defense;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }
    public void resume(){
        currentHealth = health;
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }//当前生命值
    public Item drop(){
        return Tools.getRandomItem(levelNumber);
    }//获得随机东西
    public void attackPokemon(pokemon pokemon) {
        int minusHealth=this.attack*this.attack/ pokemon.getDefense();
        if(minusHealth==0)minusHealth=1;
        else if (minusHealth> pokemon.getCurrentHealth()) {
            minusHealth=pokemon.getCurrentHealth();
        }
        //剩余血量
        int restHealth= pokemon.getCurrentHealth()-minusHealth;
        pokemon.setCurrentHealth(restHealth);
        System.err.println(name+"对"+pokemon.getName()+"造成了"+minusHealth+"点伤害");
    }
}
