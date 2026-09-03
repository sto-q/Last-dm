package com.cry.pokrmon.Level;
/*
关卡
 */
public class Level {
    private int level;//关卡编号
    private LevelMap map;//关卡地图
    private Level nextLevel;
    private Level lastLevel;

    public Level( Level lastLevel,int level,  Level nextLevel) {
        this.level = level;
        this.nextLevel = nextLevel;
        this.lastLevel = lastLevel;
        this.map = new LevelMap(level);
    }

    public int getLevel() {
        return level;
    }


    public LevelMap getMap() {
        return map;
    }


    public Level getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(Level nextLevel) {
        this.nextLevel = nextLevel;
    }

    public Level getLastLevel() {
        return lastLevel;
    }

    public void setLastLevel(Level lastLevel) {
        this.lastLevel = lastLevel;
    }
}
