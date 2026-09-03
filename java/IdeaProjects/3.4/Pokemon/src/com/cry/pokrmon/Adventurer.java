package com.cry.pokrmon;
import com.cry.pokrmon.Level.Level;
import com.cry.pokrmon.Level.LevelMap;
import com.cry.pokrmon.item.HP;
import com.cry.pokrmon.item.Item;
import com.cry.pokrmon.item.Monster;
import com.cry.pokrmon.item.Pokemon.Bulbasuar;
import com.cry.pokrmon.item.Pokemon.pokemon;
import com.cry.pokrmon.item.Treasure;
import com.cry.pokrmon.item.equipment.Equipment;
import com.cry.pokrmon.util.Tools;
import com.cry.pokrmon.item.portal;

import java.util.Arrays;

public class Adventurer implements DisplayItem{
    private Equipment[] equipment={};
    private HP[] medicines={new HP(1,10)
    };
    public pokemon[] pokemons={
            new Bulbasuar()
    };
    private Item[][] packitem={
            medicines,
            equipment,
            pokemons,
    };
    private Level currentlevel;
    public void start(){
        currentlevel=new Level(null,1,null);
        LevelMap map=currentlevel.getMap();
        map.addAdventurer(this);
        while(true){
            currentlevel.getMap().show();
            System.out.println("移动（WASD）退出 E");
            char direct= Tools.getinputChar();
            if(direct=='E'){
                System.out.println("确认退出? Y/N");
                char quit=Tools.getinputChar();
                if(Character.toUpperCase(quit)=='Y'){
                    System.out.println("感谢游玩");
                    break;
                }
            }else {
                Item iem=discovery(direct);
                if(iem!=null){
                    iem.setDiscory(true);
                    currentlevel.getMap().show();
                }
                if(iem instanceof Treasure){
                    processTreasure((Treasure)iem,direct);
                } else if (iem instanceof Monster) {
                    processMonster((Monster)iem,direct);
                } else if (iem instanceof portal) {
                    System.out.println("发现传送门是否进入？ Y/N");
                    char pass=Tools.getinputChar();
                    if(Character.toUpperCase(pass)=='Y'){
                        if(((portal) iem).isNext()){
                            Level nextlevel=currentlevel.getNextLevel();
                            if(nextlevel==null){
                                nextlevel=new Level(currentlevel,currentlevel.getLevel()+1,null);
                                nextlevel.getMap().addAdventurer(this);
                                currentlevel.setNextLevel(nextlevel);
                            }
                            currentlevel=nextlevel;
                        }else {
                            Level prevLevel=currentlevel.getLastLevel();
                            if(prevLevel==null) {
                                System.out.println("NNOO");
                            }else {
                                currentlevel=prevLevel;
                            }
                        }
                    }
                }else {
                    move(direct);
                }
            }
        }
    }
    private void processMonster(Monster monster,char direct){
        System.out.println("发现"+monster.getName()+"是否清除Y/N");
        char  clear=Tools.getinputChar();
        if(Character.toUpperCase(clear)=='Y'){
            for(int i=0; i<pokemons.length; i++){
                System.out.println((i+1)+"\t"+pokemons[i].getItemInformation());
            }
            System.out.println("选择精灵 :");
            int number=Tools.getInputNumber(1,pokemons.length);
            pokemon pokemon=pokemons[number-1];
            while(monster.getCurrentHealth()>0&&pokemon.getCurrentHealth()>0){
                double rate=pokemon.getHealthpercent();
                if(rate<0.5){
                    System.out.println("生命值小于50%是否使用药品:Y/N");
                    char eatHP=Tools.getinputChar();
                    if(Character.toUpperCase(eatHP)=='Y'){
                        HP hp=geCurrenttHP(currentlevel.getLevel());
                        if(hp==null){
                            System.out.println("没有药品了");
                        }else {
                            if(hp.canDestroy()){
                                int index=-1;
                                for(int i=0;i<medicines.length;i++){
                                    if(hp.getLevelNumber()==medicines[i].getLevelNumber()){
                                        index=i;
                                        break;
                                    }
                                }
                                System.arraycopy(medicines,index+1,medicines,index,medicines.length-index-1);
                                System.out.println("无药可用");
                            }else {
                                int heath=hp.use();
                                pokemon.setCurrentHealth(pokemon.getCurrentHealth()+heath);
                            }
                        }
                    }
                }
                Tools.lazy(300L);
                pokemon.attackMonsters(monster);
                Tools.lazy(300L);
                monster.attackPokemon(pokemon);
                Tools.lazy(300L);
            }
            if(monster.getCurrentHealth()==0){
                System.out.println("怪物被击败");
                Item dropitem=monster.drop();
                System.out.println("获得"+ dropitem.getItemInformation());
                processTiem(dropitem);
                move(direct);
            }else {
                monster.resume();
                System.out.println(pokemon.getName()+"被击败");
            }
        }
    }
    private HP geCurrenttHP(int levelNumber){
        if(levelNumber==0)return null;
        HP hp=null;
        for(int i=0;i<medicines.length;i++){
            if(medicines[i].getLevelNumber()==currentlevel.getLevel()){
                hp=medicines[i];
                break;
            }
        }
        if(hp==null){
            return geCurrenttHP(levelNumber-1);
        }else {
            return hp;
        }
    }
    //处理宝箱
    public void processTreasure(Treasure iem,char direct){
        System.out.println("发现宝箱是否打开？Y/N");
        char open=Tools.getinputChar();
        if(Character.toUpperCase(open)=='Y'){
            Item TreasureItem=iem.open();
            System.out.println("获得"+ TreasureItem.getItemInformation());
            processTiem(TreasureItem);
//            System.out.println("获得"+ TreasureItem.getItemInformation());
            //宝箱处理后移动到宝箱位置
            move(direct);
        }
     }
     public void processTiem(Item Item){
         if(Item instanceof HP){
             for(HP hp:medicines){
                 if(hp.getLevelNumber()== Item.getLevelNumber()){
                     hp.addCount(((HP)Item).getCount());
                     break;
                 }
             }
         } else if (Item instanceof Equipment) {
             System.out.printf("发现新装备%s是否更换？Y/N\n",Item.getName());
             char change=Tools.getinputChar();
             if(Character.toUpperCase(change)=='Y'){
                 Equipment old=null;
                 for(pokemon pokemon:pokemons){
                     old=pokemon.changeEquipment((Equipment)Item);
                     if(old==null)break;
                 }
                 if(old!=null){
                     equipment= Arrays.copyOf(equipment,equipment.length+1);
                     equipment[equipment.length-1]=old;
                 }
             }
         }else {
             int index=-1;
             for(int i=0;i<pokemons.length;i++){
                 if(Item.getClass()==pokemons[i].getClass()){
                     index=i;
                     break;
                 }
             }
             if(index==-1){
                 pokemons=Arrays.copyOf(pokemons,pokemons.length+1);
                 pokemons[pokemons.length-1]=(pokemon)Item;
             }else {
                 System.out.println("发现可以升星Y/N");
                 char change=Tools.getinputChar();
                 if(Character.toUpperCase(change)=='Y'){
                     pokemons[index].merge((pokemon)Item);
                 }else{
                     pokemons=Arrays.copyOf(pokemons,pokemons.length+1);
                     pokemons[pokemons.length-1]=(pokemon)Item;
                 }
             }
         }
     }
    public Item discovery(char direct){
        return (Item) currentlevel.getMap().getPosititionItem(Character.toUpperCase(direct));
    }
    public void move(char direct){
        currentlevel.getMap().move(Character.toUpperCase(direct));
    }
    @Override
    public String getItemInformation() {
        return "$";
    }
}
