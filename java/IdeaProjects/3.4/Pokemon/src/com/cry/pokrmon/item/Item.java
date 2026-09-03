package com.cry.pokrmon.item;

import com.cry.pokrmon.DisplayItem;
/*
物品
 */
public abstract class Item implements DisplayItem {
    /*
    物品名称
     */
    protected String name;
    /*
    关卡编号
     */
    protected int levelNumber;
    /*
    是否被探索
     */
    protected  boolean discory;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int levelNumber) {
        this.name = name;
        this.levelNumber = levelNumber;
    }

    public String getName() {
        return name;
    }

    public int getLevelNumber() {

        return levelNumber;
    }

    public void setDiscory(boolean discory) {
        this.discory = discory;
    }
}
